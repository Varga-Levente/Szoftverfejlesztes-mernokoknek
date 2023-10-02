package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.CinemaRoom;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.CinemaRoomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
public class CinemaRoomController {

    private final CinemaRoomRepository cinemaRoomRepository;
    private EntityManager entityManager;

    public CinemaRoomController(CinemaRoomRepository cinemaRoomRepository, EntityManager entityManager) {
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.entityManager = entityManager;
    }

    //TODO: This should be a post request in the future
    //Create a new room with get parameters
    //http://localhost:8080/api/v1/room/create?name=room1&numRows=10&seatsPerRow=10
    @GetMapping("/create")
    public String createRoom(@RequestParam String name,@RequestParam int numRows,@RequestParam int seatsPerRow) {
        //Build the room from the parameters
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setName(name);
        cinemaRoom.setNumRows(numRows);
        cinemaRoom.setSeatsPerRow(seatsPerRow);
        //Save the room to the database
        cinemaRoomRepository.save(cinemaRoom);

        //Return success message
        return name+" created";
    }

    //Get all rooms
    //http://localhost:8080/api/v1/room/getAll
    @GetMapping("/getAll")
    public List<CinemaRoom> getAllRooms() {
        return cinemaRoomRepository.findAll();
    }

    //Clear all rooms
    //http://localhost:8080/api/v1/room/clearAll
    @Transactional
    @RequestMapping("/clearAll")
    public List clearAllRooms() {
        List<String> states = new ArrayList<>();
        //Delete all movies if there are any
        if (cinemaRoomRepository.count() > 0) {
            cinemaRoomRepository.deleteAll();
            states.add("Rooms deleted");

            //Reset auto increment
            Query query = entityManager.createNativeQuery("ALTER TABLE project_cinema_rooms AUTO_INCREMENT = 1");
            query.executeUpdate();
            states.add("Auto increment id reset");

        }else {
            states.add("No rooms to delete");
        }
        return states;
    }

    //TODO: Create a method to delete a room by id
    //TODO: Create a method to update a room by id
    //TODO: Create a method to get a room by id

}
