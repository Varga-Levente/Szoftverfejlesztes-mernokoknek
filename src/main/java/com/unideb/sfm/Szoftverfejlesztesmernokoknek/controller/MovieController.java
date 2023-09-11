package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.MovieRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.utils.ReadJSON;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;
    private EntityManager entityManager;

    public MovieController(MovieRepository movieRepository, EntityManager entityManager) {
        this.movieRepository = movieRepository;
        this.entityManager = entityManager;
    }

    @RequestMapping(path = "api/v1/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @PostMapping(path = "api/v1/movies")
    public String addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie.toString();
    }

    @Transactional
    @RequestMapping(path = "api/v1/movies/reset")
    public List resetMovies() throws IOException {
        List<String> states = new ArrayList<>();

        //Delete all movies if there are any
        if (movieRepository.count() > 0) {
            //Delete all movies from existing table
            movieRepository.deleteAll();
            states.add("Movies deleted");

            //Reset the id sequence
            String seqname = Movie.getSequenceName();
            String resetSql = "ALTER SEQUENCE "+seqname.toUpperCase()+" RESTART WITH 1";
            entityManager.createNativeQuery(resetSql).executeUpdate();
            //Add response to states
            states.add("Id sequence reset to 1");

            //Read default movies from json file and id each of them
            ReadJSON readJSON = new ReadJSON();
            //Get the movies from the json file
            List<Movie> movies = readJSON.getItemFromJson();
            states.add("Movies read from resources/data.json");

            //Save the movies to the database with while loop
            int i = 0;
            while (i < movies.size()) {
                movieRepository.save(movies.get(i));
                // Debugging purposes
                //states.add("Movie added: "+movies.get(i).toString());
                i++;
            }
            states.add("Movies saved to database");

        } else {
            states.add("No movies to delete");

            //Read default movies from json file and id each of them
            ReadJSON readJSON = new ReadJSON();
            //Create a sequence for the movie ids
            int id = 1;
            //Get the movies from the json file
            List<Movie> movies = readJSON.getItemFromJson();
            //Set the ids for the movies
            for (Movie movie : movies) {
                movie.setId(id);
                id++;
            }
            states.add("Movies read from resources/data.json");

            //Save the movies to the database
            movieRepository.saveAll(movies);
            states.add("Movies saved to database");
        }

        return states;
    }

    @RequestMapping(path = "api/v1/movies/deleteAll")
    public ResponseEntity<String> deleteAllMovies() {
        movieRepository.deleteAll();
        return new ResponseEntity<>("All movies deleted", HttpStatus.OK);
    }

}
