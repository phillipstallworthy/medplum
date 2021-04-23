/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class TestScriptRequestHeaderTest {

    @Test
    public void testId() {
        assertEquals("x", TestScript.TestScriptRequestHeader.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, TestScript.TestScriptRequestHeader.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testField() {
        assertEquals("x", TestScript.TestScriptRequestHeader.create().field("x").build().field());
    }

    @Test
    public void testValue() {
        assertEquals("x", TestScript.TestScriptRequestHeader.create().value("x").build().value());
    }
}