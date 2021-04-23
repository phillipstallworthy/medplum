/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class StructureMapTargetTest {

    @Test
    public void testId() {
        assertEquals("x", StructureMap.StructureMapTarget.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapTarget.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testContext() {
        assertEquals("x", StructureMap.StructureMapTarget.create().context("x").build().context());
    }

    @Test
    public void testContextType() {
        assertEquals("x", StructureMap.StructureMapTarget.create().contextType("x").build().contextType());
    }

    @Test
    public void testElement() {
        assertEquals("x", StructureMap.StructureMapTarget.create().element("x").build().element());
    }

    @Test
    public void testVariable() {
        assertEquals("x", StructureMap.StructureMapTarget.create().variable("x").build().variable());
    }

    @Test
    public void testListMode() {
        final java.util.List<String> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapTarget.create().listMode(value).build().listMode());
    }

    @Test
    public void testListRuleId() {
        assertEquals("x", StructureMap.StructureMapTarget.create().listRuleId("x").build().listRuleId());
    }

    @Test
    public void testTransform() {
        assertEquals("x", StructureMap.StructureMapTarget.create().transform("x").build().transform());
    }

    @Test
    public void testParameter() {
        final java.util.List<StructureMap.StructureMapParameter> value = java.util.Collections.emptyList();
        assertEquals(value, StructureMap.StructureMapTarget.create().parameter(value).build().parameter());
    }
}