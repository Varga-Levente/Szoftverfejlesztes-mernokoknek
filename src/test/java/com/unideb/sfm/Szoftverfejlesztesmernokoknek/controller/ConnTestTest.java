package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

//Using this annotation to use the application-test.properties file
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ConnTestTest {

    @Test
    void connTest() {
        ConnTest connTest = new ConnTest();
        assertEquals("Connection is working!", connTest.ConnTest());
    }
}