package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.CinemaRoom;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Reservation;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.CinemaRoomRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.MovieRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.ReservationRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, UserRepository userRepository, MovieRepository movieRepository, CinemaRoomRepository cinemaRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    //TODO: This should be a POST request in the future
    //Create a new reservation with get parameters The movie already has CinemaRoom only need to specify the row and seat
    //http://localhost:8080/api/v1/reservation/create?userId=1&movieId=1&cinemaRoomId=1&row=1&seat=1
    @RequestMapping("/create")
    public ResponseEntity<String> createReservation(
            @RequestParam int userId,
            @RequestParam int movieId,
            @RequestParam int cinemaRoomId,
            @RequestParam int row,
            @RequestParam int seat
    ) {
        // Ellenőrizd, hogy a felhasználó, a film és a terem létezik-e az adatbázisban
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);
        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(cinemaRoomId).orElse(null);

        if (user == null || movie == null || cinemaRoom == null) {
            return ResponseEntity.badRequest().body("Felhasználó, film vagy terem nem található az adatbázisban.");
        }

        // Hozz létre egy új foglalást a megadott paraméterekkel
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setMovie(movie);
        reservation.setRow(row);
        reservation.setCinemaRoom(cinemaRoom);
        reservation.setSeat(seat);

        // Mentsd el a foglalást az adatbázisban
        reservationRepository.save(reservation);

        return ResponseEntity.ok("Foglalás sikeresen létrehozva.");
    }

    //Get all reservations
    //http://localhost:8080/api/v1/reservation/getAll
    @RequestMapping("/getAll")
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationRepository.findAll());
    }

    //Check if a seat is reserved by movieId (Get data from Reservation repository)
    //http://localhost:8080/api/v1/reservation/isReserved?movieId=1&row=1&seat=1
    @RequestMapping("/isReserved")
    public ResponseEntity<Boolean> isReserved(
            @RequestParam int movieId,
            @RequestParam int row,
            @RequestParam int seat
    ) {
        // Ellenőrizd, hogy a film létezik-e az adatbázisban
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if (movie == null) {
            return ResponseEntity.badRequest().body(false);
        }

        // Ellenőrizd, hogy a megadott hely már foglalt-e
        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getMovie().getId() == movieId && reservation.getRow() == row && reservation.getSeat() == seat) {
                return ResponseEntity.ok(true);
            }
        }

        return ResponseEntity.ok(false);
    }

    //TODO: Create delete reservation endpoint (DELETE request)
    //TODO: Create update reservation endpoint (PUT request)
    //TODO: Create get reservations by user endpoint (GET request)
}
