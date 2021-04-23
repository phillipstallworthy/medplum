/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class MedicinalProductPharmaceuticalTargetSpeciesTest {

    @Test
    public void testId() {
        assertEquals("x", MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalTargetSpecies.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalTargetSpecies.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testCode() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalTargetSpecies.create().code(value).build().code());
    }

    @Test
    public void testWithdrawalPeriod() {
        final java.util.List<MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalWithdrawalPeriod> value = java.util.Collections.emptyList();
        assertEquals(value, MedicinalProductPharmaceutical.MedicinalProductPharmaceuticalTargetSpecies.create().withdrawalPeriod(value).build().withdrawalPeriod());
    }
}