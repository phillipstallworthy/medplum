/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class OperationDefinitionReferencedFromTest {

    @Test
    public void testId() {
        assertEquals("x", OperationDefinition.OperationDefinitionReferencedFrom.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, OperationDefinition.OperationDefinitionReferencedFrom.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testSource() {
        assertEquals("x", OperationDefinition.OperationDefinitionReferencedFrom.create().source("x").build().source());
    }

    @Test
    public void testSourceId() {
        assertEquals("x", OperationDefinition.OperationDefinitionReferencedFrom.create().sourceId("x").build().sourceId());
    }
}