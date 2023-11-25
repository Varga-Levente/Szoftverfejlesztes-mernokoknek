package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Cinema;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public ResponseEntity<?> addCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
        return ResponseEntity.ok("Cinema added successfully");
    }

    public ResponseEntity<?> removeCinemaById(Integer cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId).orElse(null);
        if (cinema == null) {
            return ResponseEntity.notFound().build();
        }

        cinemaRepository.deleteById(cinemaId);
        return ResponseEntity.ok("Cinema deleted successfully");
    }

    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }
}
