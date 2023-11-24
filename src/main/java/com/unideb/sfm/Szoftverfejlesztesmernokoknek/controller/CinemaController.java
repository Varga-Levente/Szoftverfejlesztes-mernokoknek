package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Cinema;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.CinemaRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private CinemaService cinemaService;

    // ;(
}
