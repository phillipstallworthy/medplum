/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class InsurancePlanGeneralCostTest {

    @Test
    public void testId() {
        assertEquals("x", InsurancePlan.InsurancePlanGeneralCost.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, InsurancePlan.InsurancePlanGeneralCost.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testType() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, InsurancePlan.InsurancePlanGeneralCost.create().type(value).build().type());
    }

    @Test
    public void testGroupSize() {
        assertEquals(1, InsurancePlan.InsurancePlanGeneralCost.create().groupSize(1).build().groupSize());
    }

    @Test
    public void testCost() {
        final Money value = Money.create().build();
        assertEquals(value, InsurancePlan.InsurancePlanGeneralCost.create().cost(value).build().cost());
    }

    @Test
    public void testComment() {
        assertEquals("x", InsurancePlan.InsurancePlanGeneralCost.create().comment("x").build().comment());
    }
}