/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ExampleScenarioStepTest {

    @Test
    public void testId() {
        assertEquals("x", ExampleScenario.ExampleScenarioStep.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, ExampleScenario.ExampleScenarioStep.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testProcess() {
        final java.util.List<ExampleScenario.ExampleScenarioProcess> value = java.util.Collections.emptyList();
        assertEquals(value, ExampleScenario.ExampleScenarioStep.create().process(value).build().process());
    }

    @Test
    public void testPause() {
        assertEquals(true, ExampleScenario.ExampleScenarioStep.create().pause(true).build().pause());
    }

    @Test
    public void testOperation() {
        final ExampleScenario.ExampleScenarioOperation value = ExampleScenario.ExampleScenarioOperation.create().build();
        assertEquals(value, ExampleScenario.ExampleScenarioStep.create().operation(value).build().operation());
    }

    @Test
    public void testAlternative() {
        final java.util.List<ExampleScenario.ExampleScenarioAlternative> value = java.util.Collections.emptyList();
        assertEquals(value, ExampleScenario.ExampleScenarioStep.create().alternative(value).build().alternative());
    }
}