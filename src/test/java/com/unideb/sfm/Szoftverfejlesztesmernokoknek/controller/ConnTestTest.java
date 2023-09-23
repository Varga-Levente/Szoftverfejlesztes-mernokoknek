package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConnTestTest {

    @Test
    void connTest() {
        ConnTest connTest = new ConnTest();
        assertEquals("Connection is working!", connTest.ConnTest());
    }
}