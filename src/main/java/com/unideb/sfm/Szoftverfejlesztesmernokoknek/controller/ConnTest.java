package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ConnTest {
    @GetMapping("/ConnTest")
    public String ConnTest() {
        return "Connection is working!";
    }
}
