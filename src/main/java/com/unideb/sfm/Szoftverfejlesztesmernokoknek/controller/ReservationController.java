package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Reservation;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/removeReservationById/{reservationId}")
    public void removeReservationById(@PathVariable Long reservationId) {
        reservationService.removeReservationById(reservationId);
    }

    // További végpontok, például getReservationById, updateReservation stb.
}
