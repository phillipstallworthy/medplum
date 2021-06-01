/*
 * Generated by @medplum/generator
 * Do not edit manually.
 */

import { CodeableConcept } from './CodeableConcept';
import { Extension } from './Extension';
import { Identifier } from './Identifier';
import { Meta } from './Meta';
import { Narrative } from './Narrative';
import { Reference } from './Reference';
import { Resource } from './Resource';

/**
 * A patient's point-in-time set of recommendations (i.e. forecasting)
 * according to a published schedule with optional supporting
 * justification.
 */
export interface ImmunizationRecommendation {

  /**
   * This is a ImmunizationRecommendation resource
   */
  readonly resourceType: 'ImmunizationRecommendation';

  /**
   * The logical id of the resource, as used in the URL for the resource.
   * Once assigned, this value never changes.
   */
  readonly id?: string;

  /**
   * The metadata about the resource. This is content that is maintained by
   * the infrastructure. Changes to the content might not always be
   * associated with version changes to the resource.
   */
  readonly meta?: Meta;

  /**
   * A reference to a set of rules that were followed when the resource was
   * constructed, and which must be understood when processing the content.
   * Often, this is a reference to an implementation guide that defines the
   * special rules along with other profiles etc.
   */
  readonly implicitRules?: string;

  /**
   * The base language in which the resource is written.
   */
  readonly language?: string;

  /**
   * A human-readable narrative that contains a summary of the resource and
   * can be used to represent the content of the resource to a human. The
   * narrative need not encode all the structured data, but is required to
   * contain sufficient detail to make it &quot;clinically safe&quot; for a human to
   * just read the narrative. Resource definitions may define what content
   * should be represented in the narrative to ensure clinical safety.
   */
  readonly text?: Narrative;

  /**
   * These resources do not have an independent existence apart from the
   * resource that contains them - they cannot be identified independently,
   * and nor can they have their own independent transaction scope.
   */
  readonly contained?: Resource[];

  /**
   * May be used to represent additional information that is not part of
   * the basic definition of the resource. To make the use of extensions
   * safe and manageable, there is a strict set of governance  applied to
   * the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met
   * as part of the definition of the extension.
   */
  readonly extension?: Extension[];

  /**
   * May be used to represent additional information that is not part of
   * the basic definition of the resource and that modifies the
   * understanding of the element that contains it and/or the understanding
   * of the containing element's descendants. Usually modifier elements
   * provide negation or qualification. To make the use of extensions safe
   * and manageable, there is a strict set of governance applied to the
   * definition and use of extensions. Though any implementer is allowed to
   * define an extension, there is a set of requirements that SHALL be met
   * as part of the definition of the extension. Applications processing a
   * resource are required to check for modifier extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on
   * Resource or DomainResource (including cannot change the meaning of
   * modifierExtension itself).
   */
  readonly modifierExtension?: Extension[];

  /**
   * A unique identifier assigned to this particular recommendation record.
   */
  readonly identifier?: Identifier[];

  /**
   * The patient the recommendation(s) are for.
   */
  readonly patient?: Reference;

  /**
   * The date the immunization recommendation(s) were created.
   */
  readonly date?: Date;

  /**
   * Indicates the authority who published the protocol (e.g. ACIP).
   */
  readonly authority?: Reference;

  /**
   * Vaccine administration recommendations.
   */
  readonly recommendation?: ImmunizationRecommendationRecommendation[];
}

/**
 * A patient's point-in-time set of recommendations (i.e. forecasting)
 * according to a published schedule with optional supporting
 * justification.
 */
export interface ImmunizationRecommendationDateCriterion {

  /**
   * Unique id for the element within a resource (for internal references).
   * This may be any string value that does not contain spaces.
   */
  readonly id?: string;

  /**
   * May be used to represent additional information that is not part of
   * the basic definition of the element. To make the use of extensions
   * safe and manageable, there is a strict set of governance  applied to
   * the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met
   * as part of the definition of the extension.
   */
  readonly extension?: Extension[];

  /**
   * May be used to represent additional information that is not part of
   * the basic definition of the element and that modifies the
   * understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually
   * modifier elements provide negation or qualification. To make the use
   * of extensions safe and manageable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any
   * implementer can define an extension, there is a set of requirements
   * that SHALL be met as part of the definition of the extension.
   * Applications processing a resource are required to check for modifier
   * extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on
   * Resource or DomainResource (including cannot change the meaning of
   * modifierExtension itself).
   */
  readonly modifierExtension?: Extension[];

  /**
   * Date classification of recommendation.  For example, earliest date to
   * give, latest date to give, etc.
   */
  readonly code?: CodeableConcept;

  /**
   * The date whose meaning is specified by dateCriterion.code.
   */
  readonly value?: Date;
}

/**
 * A patient's point-in-time set of recommendations (i.e. forecasting)
 * according to a published schedule with optional supporting
 * justification.
 */
export interface ImmunizationRecommendationRecommendation {

  /**
   * Unique id for the element within a resource (for internal references).
   * This may be any string value that does not contain spaces.
   */
  readonly id?: string;

  /**
   * May be used to represent additional information that is not part of
   * the basic definition of the element. To make the use of extensions
   * safe and manageable, there is a strict set of governance  applied to
   * the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met
   * as part of the definition of the extension.
   */
  readonly extension?: Extension[];

  /**
   * May be used to represent additional information that is not part of
   * the basic definition of the element and that modifies the
   * understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually
   * modifier elements provide negation or qualification. To make the use
   * of extensions safe and manageable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any
   * implementer can define an extension, there is a set of requirements
   * that SHALL be met as part of the definition of the extension.
   * Applications processing a resource are required to check for modifier
   * extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on
   * Resource or DomainResource (including cannot change the meaning of
   * modifierExtension itself).
   */
  readonly modifierExtension?: Extension[];

  /**
   * Vaccine(s) or vaccine group that pertain to the recommendation.
   */
  readonly vaccineCode?: CodeableConcept[];

  /**
   * The targeted disease for the recommendation.
   */
  readonly targetDisease?: CodeableConcept;

  /**
   * Vaccine(s) which should not be used to fulfill the recommendation.
   */
  readonly contraindicatedVaccineCode?: CodeableConcept[];

  /**
   * Indicates the patient status with respect to the path to immunity for
   * the target disease.
   */
  readonly forecastStatus?: CodeableConcept;

  /**
   * The reason for the assigned forecast status.
   */
  readonly forecastReason?: CodeableConcept[];

  /**
   * Vaccine date recommendations.  For example, earliest date to
   * administer, latest date to administer, etc.
   */
  readonly dateCriterion?: ImmunizationRecommendationDateCriterion[];

  /**
   * Contains the description about the protocol under which the vaccine
   * was administered.
   */
  readonly description?: string;

  /**
   * One possible path to achieve presumed immunity against a disease -
   * within the context of an authority.
   */
  readonly series?: string;

  /**
   * Nominal position of the recommended dose in a series (e.g. dose 2 is
   * the next recommended dose).
   */
  readonly doseNumberPositiveInt?: number;

  /**
   * Nominal position of the recommended dose in a series (e.g. dose 2 is
   * the next recommended dose).
   */
  readonly doseNumberString?: string;

  /**
   * The recommended number of doses to achieve immunity.
   */
  readonly seriesDosesPositiveInt?: number;

  /**
   * The recommended number of doses to achieve immunity.
   */
  readonly seriesDosesString?: string;

  /**
   * Immunization event history and/or evaluation that supports the status
   * and recommendation.
   */
  readonly supportingImmunization?: Reference[];

  /**
   * Patient Information that supports the status and recommendation.  This
   * includes patient observations, adverse reactions and
   * allergy/intolerance information.
   */
  readonly supportingPatientInformation?: Reference[];
}