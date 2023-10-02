package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaRoom cinemaRoom;

    private Integer row;

    private Integer seat;

    public Reservation() {} // default empty constructor

    public Reservation(Integer id, User user, Movie movie, CinemaRoom cinemaRoom, Integer row, Integer seat) {
        setId(id);
        setUser(user);
        setMovie(movie);
        setCinemaRoom(cinemaRoom);
        setRow(row);
        setSeat(seat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(movie, that.movie) && Objects.equals(cinemaRoom, that.cinemaRoom) && Objects.equals(row, that.row) && Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, movie, cinemaRoom, row, seat);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}
