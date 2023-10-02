package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_cinema_rooms")
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_name")
    private String name;

    private int numRows;

    private int seatsPerRow;

    public CinemaRoom(int id, String name, int numRows, int seatsPerRow) {
        setId(id);
        setName(name);
        setNumRows(numRows);
        setSeatsPerRow(seatsPerRow);
    }

    public CinemaRoom() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaRoom that = (CinemaRoom) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(numRows, that.numRows) && Objects.equals(seatsPerRow, that.seatsPerRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numRows, seatsPerRow);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        seatsPerRow = seatsPerRow;
    }
}
