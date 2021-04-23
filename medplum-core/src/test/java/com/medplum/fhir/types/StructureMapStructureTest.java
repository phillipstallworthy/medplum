/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class StructureMapStructureTest {

    @Test
    public void testId() {
        assertEquals("x", StructureMap.StructureMapStructure.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapStructure.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testUrl() {
        assertEquals("x", StructureMap.StructureMapStructure.create().url("x").build().url());
    }

    @Test
    public void testMode() {
        assertEquals("x", StructureMap.StructureMapStructure.create().mode("x").build().mode());
    }

    @Test
    public void testAlias() {
        assertEquals("x", StructureMap.StructureMapStructure.create().alias("x").build().alias());
    }

    @Test
    public void testDocumentation() {
        assertEquals("x", StructureMap.StructureMapStructure.create().documentation("x").build().documentation());
    }
}