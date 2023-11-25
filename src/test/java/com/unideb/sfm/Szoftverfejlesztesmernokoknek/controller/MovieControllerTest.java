package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    public void testGetMovies() throws Exception {
        List<Movie> movies = Arrays.asList(
                new Movie(
                        null,
                        "Movie 1",
                        2021,
                        8.5,
                        "Overview 1",
                        "",
                        "",
                        "Action;Thriller"
                ),
                new Movie(
                        null,
                        "Movie 2",
                        2021,
                        8.5,
                        "Overview 2",
                        "",
                        "",
                        "Action;Thriller"
                )
        );

        when(movieService.getAll()).thenReturn(movies);

        mockMvc.perform(get("/api/v1/movie/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Movie 1"))
                .andExpect(jsonPath("$[1].title").value("Movie 2"));
    }

    @Test
    public void testAddMovie() throws Exception {
        Movie movie = new Movie(
                null,
                "The Nun II",
                2023,
                7,
                "In 1956 France, a priest is violently murdered, and Sister Irene begins to investigate. She once again comes face-to-face with a powerful evil.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2//5gzzkR7y3hnY8AD1wXjCnVlHba5.jpg",
                "OIC5q-fhuUM",
                "Horror;Mystery;Thriller"
        );

        List<Movie> movieList = Collections.singletonList(movie);

        when(movieService.addMovie(any())).thenAnswer(invocation -> {
            List<Movie> addedMovies = invocation.getArgument(0);
            return ResponseEntity.ok("Movie added successfully");
        });

        mockMvc.perform(post("/api/v1/movie/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(movieList)))
                .andExpect(status().isOk())
                .andExpect(content().string("Movie added successfully"));
    }

}
