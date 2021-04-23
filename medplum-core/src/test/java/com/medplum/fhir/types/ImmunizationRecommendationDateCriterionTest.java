/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ImmunizationRecommendationDateCriterionTest {

    @Test
    public void testId() {
        assertEquals("x", ImmunizationRecommendation.ImmunizationRecommendationDateCriterion.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, ImmunizationRecommendation.ImmunizationRecommendationDateCriterion.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testCode() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, ImmunizationRecommendation.ImmunizationRecommendationDateCriterion.create().code(value).build().code());
    }

    @Test
    public void testValue() {
        final java.time.Instant value = java.time.Instant.now();
        assertEquals(value, ImmunizationRecommendation.ImmunizationRecommendationDateCriterion.create().value(value).build().value());
    }
}