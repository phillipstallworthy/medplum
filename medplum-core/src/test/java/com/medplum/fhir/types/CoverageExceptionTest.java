/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class CoverageExceptionTest {

    @Test
    public void testId() {
        assertEquals("x", Coverage.CoverageException.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, Coverage.CoverageException.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testType() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, Coverage.CoverageException.create().type(value).build().type());
    }

    @Test
    public void testPeriod() {
        final Period value = Period.create().build();
        assertEquals(value, Coverage.CoverageException.create().period(value).build().period());
    }
}