/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ContractAssetTest {

    @Test
    public void testId() {
        assertEquals("x", Contract.ContractAsset.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testScope() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, Contract.ContractAsset.create().scope(value).build().scope());
    }

    @Test
    public void testType() {
        final java.util.List<CodeableConcept> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().type(value).build().type());
    }

    @Test
    public void testTypeReference() {
        final java.util.List<Reference> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().typeReference(value).build().typeReference());
    }

    @Test
    public void testSubtype() {
        final java.util.List<CodeableConcept> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().subtype(value).build().subtype());
    }

    @Test
    public void testRelationship() {
        final Coding value = Coding.create().build();
        assertEquals(value, Contract.ContractAsset.create().relationship(value).build().relationship());
    }

    @Test
    public void testContext() {
        final java.util.List<Contract.ContractContext> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().context(value).build().context());
    }

    @Test
    public void testCondition() {
        assertEquals("x", Contract.ContractAsset.create().condition("x").build().condition());
    }

    @Test
    public void testPeriodType() {
        final java.util.List<CodeableConcept> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().periodType(value).build().periodType());
    }

    @Test
    public void testPeriod() {
        final java.util.List<Period> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().period(value).build().period());
    }

    @Test
    public void testUsePeriod() {
        final java.util.List<Period> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().usePeriod(value).build().usePeriod());
    }

    @Test
    public void testText() {
        assertEquals("x", Contract.ContractAsset.create().text("x").build().text());
    }

    @Test
    public void testLinkId() {
        final java.util.List<String> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().linkId(value).build().linkId());
    }

    @Test
    public void testAnswer() {
        final java.util.List<Contract.ContractAnswer> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().answer(value).build().answer());
    }

    @Test
    public void testSecurityLabelNumber() {
        final java.util.List<Integer> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().securityLabelNumber(value).build().securityLabelNumber());
    }

    @Test
    public void testValuedItem() {
        final java.util.List<Contract.ContractValuedItem> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractAsset.create().valuedItem(value).build().valuedItem());
    }
}