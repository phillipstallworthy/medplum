/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ConsentActorTest {

    @Test
    public void testId() {
        assertEquals("x", Consent.ConsentActor.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, Consent.ConsentActor.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testRole() {
        final CodeableConcept value = CodeableConcept.create().build();
        assertEquals(value, Consent.ConsentActor.create().role(value).build().role());
    }

    @Test
    public void testReference() {
        final Reference value = Reference.create().build();
        assertEquals(value, Consent.ConsentActor.create().reference(value).build().reference());
    }
}