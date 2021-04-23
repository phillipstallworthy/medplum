/*
 * Generated by com.medplum.generator.Generator
 * Do not edit manually.
 */

package com.medplum.fhir.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class ContractSignerTest {

    @Test
    public void testId() {
        assertEquals("x", Contract.ContractSigner.create().id("x").build().id());
    }

    @Test
    public void testModifierExtension() {
        final java.util.List<Extension> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractSigner.create().modifierExtension(value).build().modifierExtension());
    }

    @Test
    public void testType() {
        final Coding value = Coding.create().build();
        assertEquals(value, Contract.ContractSigner.create().type(value).build().type());
    }

    @Test
    public void testParty() {
        final Reference value = Reference.create().build();
        assertEquals(value, Contract.ContractSigner.create().party(value).build().party());
    }

    @Test
    public void testSignature() {
        final java.util.List<Signature> value = java.util.Collections.emptyList();
        assertEquals(value, Contract.ContractSigner.create().signature(value).build().signature());
    }
}