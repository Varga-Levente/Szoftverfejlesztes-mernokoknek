package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnTest {
    @GetMapping("/ConnTest")
    public String ConnTest() {
        return "Connection is working!";
    }
}
