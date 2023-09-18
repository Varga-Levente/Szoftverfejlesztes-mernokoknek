package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.MovieRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.utils.ReadJSON;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(path = "api/v1/movies/getAllMovie")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "api/v1/movies/addMovie")
    public String addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie.toString();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(path = "api/v1/movies/getMovieById/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Integer id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(path = "api/v1/movies/getPopularMovies")
    public ResponseEntity<List<Movie>> getPopularMovies() {
        //Get all movies
        List<Movie> movies = movieRepository.findAll();
        //Create a list for the popular movies and add them to the list
        List<Movie> popularMovies = new ArrayList<>();
        //Find the movies with rating higher than 8
        for (Movie movie : movies) {
            if (movie.getRating() > 7) {
                popularMovies.add(movie);
            }
        }
        //Return the list of popular movies
        return new ResponseEntity<>(popularMovies, HttpStatus.OK);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(path = "api/v1/movies/getMoviesByCategory/{category}")
    public ResponseEntity<List<Movie>> getMovieByCategory(@PathVariable("category") String category) {
        //Get all movies
        List<Movie> movies = movieRepository.findAll();
        //Create a list for the movies with the given category and add them to the list
        List<Movie> moviesWithCategory = new ArrayList<>();
        //Make the category lowercase and find the movies with the given category (Categories are separated by ;)
        for (Movie movie : movies) {
            String categories = movie.getCategories().toLowerCase();
            if (categories.contains(category.toLowerCase())) {
                moviesWithCategory.add(movie);
            }
        }
        //Return the list of movies with the given category
        return new ResponseEntity<>(moviesWithCategory, HttpStatus.OK);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Transactional
    @RequestMapping(path = "api/v1/movies/reset")
    public List resetMovies() throws IOException {
        List<String> states = new ArrayList<>();

        //Delete all movies if there are any
        if (movieRepository.count() > 0) {
            //Delete all movies from existing table
            movieRepository.deleteAll();
            states.add("Movies deleted");

            //Reset the auto increment id in mariadb
            Query query = entityManager.createNativeQuery("ALTER TABLE project_movies AUTO_INCREMENT = 1");
            query.executeUpdate();
            states.add("Auto increment id reset");

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
                states.add("Movie added: "+movies.get(i).toString());
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @DeleteMapping(path = "api/v1/movies/deleteAll")
    public ResponseEntity<String> deleteAllMovies() {
        movieRepository.deleteAll();
        return new ResponseEntity<>("All movies deleted", HttpStatus.OK);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
