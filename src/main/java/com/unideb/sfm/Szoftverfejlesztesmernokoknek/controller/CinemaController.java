package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Cinema;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.CinemaRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/cinema")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private CinemaService cinemaService;

    @DeleteMapping("remove/{cinemaId}")
    public ResponseEntity<?> removeCinemaById(@PathVariable("cinemaId") Integer cinemaId) {
        return cinemaService.removeCinemaById(cinemaId);
    }

    @PostMapping("add")
    public ResponseEntity<?> addCinema(@RequestBody List<Cinema> cinema) {
        return cinemaService.addCinema(cinema);
    }

    @GetMapping("getAll")
    public Iterable<Cinema> getAll() {
        return cinemaService.getAll();
    }

}
