/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class DetectedIssueMitigationTest {

    @Test
    public void testId() {
        assertEquals("x", DetectedIssue.DetectedIssueMitigation.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, DetectedIssue.DetectedIssueMitigation.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testAction() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, DetectedIssue.DetectedIssueMitigation.create().action(value).build().action());
    }

    @Test
    public void testDate() {
        final java.time.Instant value = java.time.Instant.now();
        assertEquals(value, DetectedIssue.DetectedIssueMitigation.create().date(value).build().date());
    }

    @Test
    public void testAuthor() {
        final Reference value = Reference.create().build();
        assertEquals(value, DetectedIssue.DetectedIssueMitigation.create().author(value).build().author());
    }
}