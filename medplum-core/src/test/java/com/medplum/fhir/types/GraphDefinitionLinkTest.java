/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class GraphDefinitionLinkTest {

    @Test
    public void testId() {
        assertEquals("x", GraphDefinition.GraphDefinitionLink.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, GraphDefinition.GraphDefinitionLink.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testPath() {
        assertEquals("x", GraphDefinition.GraphDefinitionLink.create().path("x").build().path());
    }

    @Test
    public void testSliceName() {
        assertEquals("x", GraphDefinition.GraphDefinitionLink.create().sliceName("x").build().sliceName());
    }

    @Test
    public void testMin() {
        assertEquals(1, GraphDefinition.GraphDefinitionLink.create().min(1).build().min());
    }

    @Test
    public void testMax() {
        assertEquals("x", GraphDefinition.GraphDefinitionLink.create().max("x").build().max());
    }

    @Test
    public void testDescription() {
        assertEquals("x", GraphDefinition.GraphDefinitionLink.create().description("x").build().description());
    }

    @Test
    public void testTarget() {
        final java.util.List<GraphDefinition.GraphDefinitionTarget> value = java.util.Collections.emptyList();
        assertEquals(value, GraphDefinition.GraphDefinitionLink.create().target(value).build().target());
    }
}