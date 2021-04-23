/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ConsentDataTest {

    @Test
    public void testId() {
        assertEquals("x", Consent.ConsentData.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, Consent.ConsentData.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testMeaning() {
        assertEquals("x", Consent.ConsentData.create().meaning("x").build().meaning());
    }

    @Test
    public void testReference() {
        final Reference value = Reference.create().build();
        assertEquals(value, Consent.ConsentData.create().reference(value).build().reference());
    }
}