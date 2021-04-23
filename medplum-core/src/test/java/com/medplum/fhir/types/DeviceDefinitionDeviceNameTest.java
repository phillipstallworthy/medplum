/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class DeviceDefinitionDeviceNameTest {

    @Test
    public void testId() {
        assertEquals("x", DeviceDefinition.DeviceDefinitionDeviceName.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, DeviceDefinition.DeviceDefinitionDeviceName.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testName() {
        assertEquals("x", DeviceDefinition.DeviceDefinitionDeviceName.create().name("x").build().name());
    }

    @Test
    public void testType() {
        assertEquals("x", DeviceDefinition.DeviceDefinitionDeviceName.create().type("x").build().type());
    }
}