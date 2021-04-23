/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class OperationDefinitionOverloadTest {

    @Test
    public void testId() {
        assertEquals("x", OperationDefinition.OperationDefinitionOverload.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, OperationDefinition.OperationDefinitionOverload.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testParameterName() {
        final java.util.List<String> value = java.util.Collections.emptyList();
        assertEquals(value, OperationDefinition.OperationDefinitionOverload.create().parameterName(value).build().parameterName());
    }

    @Test
    public void testComment() {
        assertEquals("x", OperationDefinition.OperationDefinitionOverload.create().comment("x").build().comment());
    }
}