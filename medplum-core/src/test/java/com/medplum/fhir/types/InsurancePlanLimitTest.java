/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class InsurancePlanLimitTest {

    @Test
    public void testId() {
        assertEquals("x", InsurancePlan.InsurancePlanLimit.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, InsurancePlan.InsurancePlanLimit.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testValue() {
        final Quantity value = Quantity.create().build();
        assertEquals(value, InsurancePlan.InsurancePlanLimit.create().value(value).build().value());
    }

    @Test
    public void testCode() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, InsurancePlan.InsurancePlanLimit.create().code(value).build().code());
    }
}