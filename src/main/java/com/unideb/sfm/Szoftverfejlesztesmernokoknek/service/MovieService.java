package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.MovieRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.utils.ReadJSON;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public String addMovie(Movie movie) {
        movieRepository.save(movie);
        return "Movie added";
    }

    public ResponseEntity<Movie> getMovieById(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    public ResponseEntity<List<Movie>> getPopularMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> popularMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getRating() > 7) {
                popularMovies.add(movie);
            }
        }
        return new ResponseEntity<>(popularMovies, HttpStatus.OK);
    }

    public ResponseEntity<List<Movie>> getByCategory(String category) {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> moviesWithCategory = new ArrayList<>();
        for (Movie movie : movies) {
            String categories = movie.getCategories().toLowerCase();
            if (categories.contains(category.toLowerCase())) {
                moviesWithCategory.add(movie);
            }
        }
        return new ResponseEntity<>(moviesWithCategory, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAll() {
        movieRepository.deleteAll();
        return new ResponseEntity<>("All movies deleted", HttpStatus.OK);
    }

    public ResponseEntity<Set<String>> getCategories() {
        List<Movie> movies = movieRepository.findAll();
        Set<String> allCategories = new HashSet<>(); // Ebben tároljuk az összes kategóriát

        for (Movie movie : movies) {
            String[] categoriesFromMovie = movie.getCategories().split(";");
            Collections.addAll(allCategories, categoriesFromMovie); // Hozzáadjuk a film kategóriáit az összes kategóriához
        }

        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    public List reset(){
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
            List<Movie> movies = null;
            try {
                movies = readJSON.getItemFromJson();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
            List<Movie> movies = null;
            try {
                movies = readJSON.getItemFromJson();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

}
