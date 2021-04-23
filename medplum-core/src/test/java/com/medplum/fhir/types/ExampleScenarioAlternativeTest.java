/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ExampleScenarioAlternativeTest {

    @Test
    public void testId() {
        assertEquals("x", ExampleScenario.ExampleScenarioAlternative.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, ExampleScenario.ExampleScenarioAlternative.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testTitle() {
        assertEquals("x", ExampleScenario.ExampleScenarioAlternative.create().title("x").build().title());
    }

    @Test
    public void testDescription() {
        assertEquals("x", ExampleScenario.ExampleScenarioAlternative.create().description("x").build().description());
    }

    @Test
    public void testStep() {
        final java.util.List<ExampleScenario.ExampleScenarioStep> value = java.util.Collections.emptyList();
        assertEquals(value, ExampleScenario.ExampleScenarioAlternative.create().step(value).build().step());
    }
}