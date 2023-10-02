package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.CinemaRoom;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_cinema_seats")
public class CinemaSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private CinemaRoom room;

    @Column(name = "row_number")
    private int rowNumber;

    @Column(name = "seat_number")
    private int seatNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CinemaRoom getRoom() {
        return room;
    }

    public void setRoom(CinemaRoom room) {
        this.room = room;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaSeat that = (CinemaSeat) o;
        return rowNumber == that.rowNumber && seatNumber == that.seatNumber && Objects.equals(id, that.id) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room, rowNumber, seatNumber);
    }

    @Override
    public String toString() {
        return "CinemaSeat{" +
                "id=" + id +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
