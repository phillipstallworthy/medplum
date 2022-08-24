import {
  evalFhirPathTyped,
  Filter,
  getSearchParameterDetails,
  Operator as FhirOperator,
  PropertyType,
  SortRule,
  toTypedValue,
  TypedValue,
} from '@medplum/core';
import { CodeableConcept, Coding, ContactPoint, Identifier, Resource, SearchParameter } from '@medplum/fhirtypes';
import { randomUUID } from 'crypto';
import { getClient } from '../../database';
import {
  Column,
  Condition,
  Conjunction,
  DeleteQuery,
  Disjunction,
  Expression,
  InsertQuery,
  Operator,
  SelectQuery,
} from '../sql';
import { getSearchParameters } from '../structure';
import { LookupTable } from './lookuptable';
import { compareArrays } from './util';

const TOKEN_TABLE_NAME = 'Token';

interface Token {
  readonly code: string;
  readonly system: string | undefined;
  readonly value: string | undefined;
}

/**
 * The TokenTable class is used to index and search "token" properties.
 * This can include "Identifier", "CodeableConcept", "Coding", and a number of string properties.
 * The common case for tokens is a "system" and "value" key/value pair.
 * Each token is represented as a separate row in the "Token" table.
 */
export class TokenTable implements LookupTable {
  /**
   * Returns true if the search parameter is an "token" parameter.
   * @param searchParam The search parameter.
   * @returns True if the search parameter is an "token" parameter.
   */
  isIndexed(resourceType: string, searchParam: SearchParameter): boolean {
    return isIndexed(resourceType, searchParam);
  }

  /**
   * Indexes a resource token values.
   * Attempts to reuse existing tokens if they are correct.
   * @param resource The resource to index.
   * @returns Promise on completion.
   */
  async indexResource(resource: Resource): Promise<void> {
    const tokens = getTokens(resource);
    const resourceId = resource.id as string;
    const existing = await getExistingValues(resourceId);

    if (!compareArrays(tokens, existing)) {
      const client = getClient();

      if (existing.length > 0) {
        await this.deleteValuesForResource(resource);
      }

      if (tokens.length > 0) {
        const values = [];

        for (let i = 0; i < tokens.length; i++) {
          const token = tokens[i];
          values.push({
            id: randomUUID(),
            resourceId,
            code: token.code,
            index: i,
            system: token.system?.trim(),
            value: token.value?.trim(),
          });
        }

        await new InsertQuery(TOKEN_TABLE_NAME, values).execute(client);
      }
    }
  }

  /**
   * Adds "where" conditions to the select query builder.
   * @param selectQuery The select query builder.
   * @param predicate The conjunction where conditions should be added.
   * @param filter The search filter details.
   */
  addWhere(selectQuery: SelectQuery, predicate: Conjunction, filter: Filter): void {
    const joinName = selectQuery.getNextJoinAlias();
    const subQuery = new SelectQuery(TOKEN_TABLE_NAME)
      .raw(`DISTINCT ON ("${TOKEN_TABLE_NAME}"."resourceId") *`)
      .where('code', Operator.EQUALS, filter.code)
      .orderBy('resourceId');
    const disjunction = new Disjunction([]);
    for (const option of filter.value.split(',')) {
      disjunction.expressions.push(buildWhereCondition(filter.operator, option));
    }
    subQuery.whereExpr(disjunction);
    selectQuery.join(joinName, 'id', 'resourceId', subQuery);

    // If the filter is "not equals", then we're looking for ID=null
    // If the filter is "equals", then we're looking for ID!=null
    const sqlOperator = filter.operator === FhirOperator.NOT_EQUALS ? Operator.EQUALS : Operator.NOT_EQUALS;
    predicate.expressions.push(new Condition(new Column(joinName, 'id'), sqlOperator, null));
  }

  /**
   * Adds "order by" clause to the select query builder.
   * @param selectQuery The select query builder.
   * @param sortRule The sort rule details.
   */
  addOrderBy(selectQuery: SelectQuery, sortRule: SortRule): void {
    const joinName = selectQuery.getNextJoinAlias();
    const subQuery = new SelectQuery(TOKEN_TABLE_NAME)
      .raw(`DISTINCT ON ("${TOKEN_TABLE_NAME}"."resourceId") *`)
      .where('code', Operator.EQUALS, sortRule.code)
      .orderBy('resourceId');
    selectQuery.join(joinName, 'id', 'resourceId', subQuery);
    selectQuery.orderBy(new Column(joinName, 'value'), sortRule.descending);
  }

  /**
   * Deletes the resource from the lookup table.
   * @param resource The resource to delete.
   */
  async deleteValuesForResource(resource: Resource): Promise<void> {
    const resourceId = resource.id as string;
    const client = getClient();
    await new DeleteQuery(TOKEN_TABLE_NAME).where('resourceId', Operator.EQUALS, resourceId).execute(client);
  }
}

/**
 * Returns true if the search parameter is an "token" parameter.
 * @param searchParam The search parameter.
 * @returns True if the search parameter is an "token" parameter.
 */
function isIndexed(resourceType: string, searchParam: SearchParameter): boolean {
  if (searchParam.type !== 'token') {
    return false;
  }

  const details = getSearchParameterDetails(resourceType, searchParam);
  const elementDefinition = details.elementDefinition;
  if (!elementDefinition?.type) {
    return false;
  }

  // Check for any "Identifier", "CodeableConcept", or "Coding"
  // Any of those value types require the "Token" table for full system|value search semantics.
  // The common case is that the "type" property only has one value,
  // but we need to support arrays of types for the choice-of-type properties such as "value[x]".
  for (const type of elementDefinition.type) {
    if (
      type.code === PropertyType.Identifier ||
      type.code === PropertyType.CodeableConcept ||
      type.code === PropertyType.Coding ||
      type.code === PropertyType.ContactPoint
    ) {
      return true;
    }
  }

  // This is a "token" search parameter, but it is only "code", "string", or "boolean"
  // So we can use a simple column on the resource type table.
  return false;
}

/**
 * Returns a list of all tokens in the resource to be inserted into the database.
 * This includes all values for any SearchParameter using the TokenTable.
 * @param resource The resource being indexed.
 * @returns An array of all tokens from the resource to be inserted into the database.
 */
function getTokens(resource: Resource): Token[] {
  const typedResource = [toTypedValue(resource)];
  const searchParams = getSearchParameters(resource.resourceType);
  const result: Token[] = [];
  if (searchParams) {
    for (const searchParam of Object.values(searchParams)) {
      if (isIndexed(resource.resourceType, searchParam)) {
        const typedValues = evalFhirPathTyped(searchParam.expression as string, typedResource);
        for (const typedValue of typedValues) {
          buildTokens(result, searchParam, typedValue);
        }
      }
    }
  }
  return result;
}

/**
 * Builds a list of zero or more tokens for a search parameter and value.
 * @param result The result array where tokens will be added.
 * @param searchParam The search parameter.
 * @param typedValue A typed value to be indexed for the search parameter.
 */
function buildTokens(result: Token[], searchParam: SearchParameter, typedValue: TypedValue): void {
  const { type, value } = typedValue;
  if (type === PropertyType.Identifier) {
    buildIdentifierToken(result, searchParam, value as Identifier);
  } else if (type === PropertyType.CodeableConcept) {
    buildCodeableConceptToken(result, searchParam, value as CodeableConcept);
  } else if (type === PropertyType.Coding) {
    buildCodingToken(result, searchParam, value as Coding);
  } else if (type === PropertyType.ContactPoint) {
    buildContactPointToken(result, searchParam, value as ContactPoint);
  } else {
    buildSimpleToken(result, searchParam, undefined, value?.toString() as string | undefined);
  }
}

/**
 * Builds an identifier token.
 * @param result The result array where tokens will be added.
 * @param searchParam The search parameter.
 * @param identifier The Identifier object to be indexed.
 */
function buildIdentifierToken(result: Token[], searchParam: SearchParameter, identifier: Identifier): void {
  buildSimpleToken(result, searchParam, identifier.system, identifier.value);
}

/**
 * Builds zero or more CodeableConcept tokens.
 * @param result The result array where tokens will be added.
 * @param searchParam The search parameter.
 * @param codeableConcept The CodeableConcept object to be indexed.
 */
function buildCodeableConceptToken(
  result: Token[],
  searchParam: SearchParameter,
  codeableConcept: CodeableConcept
): void {
  if (codeableConcept.coding) {
    for (const coding of codeableConcept.coding) {
      buildCodingToken(result, searchParam, coding);
    }
  }
}

/**
 * Builds a Coding token.
 * @param result The result array where tokens will be added.
 * @param searchParam The search parameter.
 * @param coding The Coding object to be indexed.
 */
function buildCodingToken(result: Token[], searchParam: SearchParameter, coding: Coding): void {
  buildSimpleToken(result, searchParam, coding.system, coding.code);
}

/**
 * Builds a ContactPoint token.
 * @param result The result array where tokens will be added.
 * @param searchParam The search parameter.
 * @param contactPoint The ContactPoint object to be indexed.
 */
function buildContactPointToken(result: Token[], searchParam: SearchParameter, contactPoint: ContactPoint): void {
  buildSimpleToken(result, searchParam, contactPoint.system, contactPoint.value);
}

/**
 * Builds a simple token.
 * @param result The result array where tokens will be added.
 * @param searchParam The search parameter.
 * @param system The token system.
 * @param value The token value.
 */
function buildSimpleToken(
  result: Token[],
  searchParam: SearchParameter,
  system: string | undefined,
  value: string | undefined
): void {
  if (system || value) {
    result.push({
      code: searchParam.code as string,
      system,
      value,
    });
  }
}

/**
 * Returns the existing list of indexed tokens.
 * @param resourceId The FHIR resource ID.
 * @returns Promise for the list of indexed tokens  .
 */
async function getExistingValues(resourceId: string): Promise<Token[]> {
  return new SelectQuery(TOKEN_TABLE_NAME)
    .column('code')
    .column('system')
    .column('value')
    .where('resourceId', Operator.EQUALS, resourceId)
    .orderBy('index')
    .execute(getClient())
    .then((result) =>
      result.map((row) => ({
        code: row.code,
        system: row.system,
        value: row.value,
      }))
    );
}

function buildWhereCondition(operator: FhirOperator, query: string): Expression {
  const parts = query.split('|');
  if (parts.length === 2) {
    return new Conjunction([
      new Condition(new Column(TOKEN_TABLE_NAME, 'system'), Operator.EQUALS, parts[0]),
      buildValueCondition(operator, parts[1]),
    ]);
  } else {
    return buildValueCondition(operator, query);
  }
}

function buildValueCondition(operator: FhirOperator, value: string): Condition {
  const column = new Column(TOKEN_TABLE_NAME, 'value');
  if (operator === FhirOperator.CONTAINS) {
    return new Condition(column, Operator.LIKE, value.trim() + '%');
  } else {
    return new Condition(column, Operator.EQUALS, value.trim());
  }
}
