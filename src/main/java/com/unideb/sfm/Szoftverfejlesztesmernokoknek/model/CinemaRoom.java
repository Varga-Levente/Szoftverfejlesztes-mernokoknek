package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "project_cinema_rooms")
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private int capacity;

    private double screenSize;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<CinemaSeat> seats;

    // További mezők, getterek és setterek

    // Konstruktorok (üres és paraméteres)

    // Getterek és setterek


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public List<CinemaSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<CinemaSeat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaRoom that = (CinemaRoom) o;
        return capacity == that.capacity && Double.compare(screenSize, that.screenSize) == 0 && Objects.equals(id, that.id) && Objects.equals(roomName, that.roomName) && Objects.equals(seats, that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomName, capacity, screenSize, seats);
    }

    @Override
    public String toString() {
        return "CinemaRoom{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", capacity=" + capacity +
                ", screenSize=" + screenSize +
                '}';
    }
}