package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.MovieRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/movie")
public class MovieController {
    //ASD

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(path = "getAll")
    public List<Movie> getMovies() {
        return movieService.getAll();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "add")
    public String addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(path = "getById/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Integer id) {
        return movieService.getMovieById(id);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(path = "getPopulars")
    public ResponseEntity<List<Movie>> getPopularMovies() {
        return movieService.getPopularMovies();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(path = "getByCategory/{category}")
    public ResponseEntity<List<Movie>> getMovieByCategory(@PathVariable("category") String category) {
        return movieService.getByCategory(category);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //http://localhost:8080/api/v1/movies/reset
    @Transactional
    @RequestMapping(path = "reset")
    public List resetMovies() throws IOException {
        return movieService.reset();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @DeleteMapping(path = "removeAll")
    public ResponseEntity<String> deleteAllMovies() {
        return movieService.deleteAll();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //http://localhost:8080/api/v1/movies/getAllCategories
    @GetMapping(path = "getCategories")
    public ResponseEntity<Set<String>> getAllCategories() {
        return movieService.getCategories();
    }

}
