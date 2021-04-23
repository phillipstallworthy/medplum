/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class EpisodeOfCareStatusHistoryTest {

    @Test
    public void testId() {
        assertEquals("x", EpisodeOfCare.EpisodeOfCareStatusHistory.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, EpisodeOfCare.EpisodeOfCareStatusHistory.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testStatus() {
        assertEquals("x", EpisodeOfCare.EpisodeOfCareStatusHistory.create().status("x").build().status());
    }

    @Test
    public void testPeriod() {
        final Period value = Period.create().build();
        assertEquals(value, EpisodeOfCare.EpisodeOfCareStatusHistory.create().period(value).build().period());
    }
}