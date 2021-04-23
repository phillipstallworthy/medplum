/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class StructureMapRuleTest {

    @Test
    public void testId() {
        assertEquals("x", StructureMap.StructureMapRule.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapRule.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testName() {
        assertEquals("x", StructureMap.StructureMapRule.create().name("x").build().name());
    }

    @Test
    public void testSource() {
        final java.util.List<StructureMap.StructureMapSource> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapRule.create().source(value).build().source());
    }

    @Test
    public void testTarget() {
        final java.util.List<StructureMap.StructureMapTarget> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapRule.create().target(value).build().target());
    }

    @Test
    public void testRule() {
        final java.util.List<StructureMap.StructureMapRule> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapRule.create().rule(value).build().rule());
    }

    @Test
    public void testDependent() {
        final java.util.List<StructureMap.StructureMapDependent> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapRule.create().dependent(value).build().dependent());
    }

    @Test
    public void testDocumentation() {
        assertEquals("x", StructureMap.StructureMapRule.create().documentation("x").build().documentation());
    }
}