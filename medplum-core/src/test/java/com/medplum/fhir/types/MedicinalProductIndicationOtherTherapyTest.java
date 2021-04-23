/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class MedicinalProductIndicationOtherTherapyTest {

    @Test
    public void testId() {
        assertEquals("x", MedicinalProductIndication.MedicinalProductIndicationOtherTherapy.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, MedicinalProductIndication.MedicinalProductIndicationOtherTherapy.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testTherapyRelationshipType() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, MedicinalProductIndication.MedicinalProductIndicationOtherTherapy.create().therapyRelationshipType(value).build().therapyRelationshipType());
    }

    @Test
    public void testMedicationCodeableConcept() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, MedicinalProductIndication.MedicinalProductIndicationOtherTherapy.create().medicationCodeableConcept(value).build().medicationCodeableConcept());
    }

    @Test
    public void testMedicationReference() {
        final Reference value = Reference.create().build();
        assertEquals(value, MedicinalProductIndication.MedicinalProductIndicationOtherTherapy.create().medicationReference(value).build().medicationReference());
    }
}