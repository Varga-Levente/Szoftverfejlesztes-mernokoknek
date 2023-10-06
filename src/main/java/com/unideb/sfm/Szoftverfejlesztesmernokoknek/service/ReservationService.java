package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Reservation;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(Reservation reservation) {
        // Itt lehetőség van validálni az adatokat és további üzleti logikát végrehajtani
        return reservationRepository.save(reservation);
    }

    public void removeReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    // További szolgáltatás metódusok, például getReservationById, updateReservation stb.
}
