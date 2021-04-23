/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class MedicationKnowledgeIngredientTest {

    @Test
    public void testId() {
        assertEquals("x", MedicationKnowledge.MedicationKnowledgeIngredient.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, MedicationKnowledge.MedicationKnowledgeIngredient.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testItemCodeableConcept() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, MedicationKnowledge.MedicationKnowledgeIngredient.create().itemCodeableConcept(value).build().itemCodeableConcept());
    }

    @Test
    public void testItemReference() {
        final Reference value = Reference.create().build();
        assertEquals(value, MedicationKnowledge.MedicationKnowledgeIngredient.create().itemReference(value).build().itemReference());
    }

    @Test
    public void testIsActive() {
        assertEquals(true, MedicationKnowledge.MedicationKnowledgeIngredient.create().isActive(true).build().isActive());
    }

    @Test
    public void testStrength() {
        final Ratio value = Ratio.create().build();
        assertEquals(value, MedicationKnowledge.MedicationKnowledgeIngredient.create().strength(value).build().strength());
    }
}