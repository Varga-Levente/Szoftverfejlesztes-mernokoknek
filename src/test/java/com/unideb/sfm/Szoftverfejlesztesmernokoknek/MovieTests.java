package com.unideb.sfm.Szoftverfejlesztesmernokoknek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller.MovieController;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.MovieRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@ExtendWith(MockitoExtension.class)
public class MovieTests {

    private MockMvc mockMvc;
    ObjectMapper om = new ObjectMapper();
    ObjectWriter ow = om.writer();

    @Mock
    private MovieRepository movierepository;

    @InjectMocks
    private MovieController moviecontroller;

    @Test
    void testMovie() {
        Movie movie = new Movie();
        movie.setCategories("Action");
        movie.setTitle("Test movie");
        movie.setRating(7);
        movie.setOverview("Test overview");
        movie.setPoster_path("Test poster path");
        movie.setYt_trailer_id("Test trailer id");
        movie.setYear(2021);

        assertEquals("Test movie", movie.getTitle());
        assertEquals("Action", movie.getCategories());
        assertEquals(7, movie.getRating());
        assertEquals("Test overview", movie.getOverview());
        assertEquals("Test poster path", movie.getPoster_path());
        assertEquals("Test trailer id", movie.getYt_trailer_id());
        assertEquals(2021, movie.getYear());
    }
}
