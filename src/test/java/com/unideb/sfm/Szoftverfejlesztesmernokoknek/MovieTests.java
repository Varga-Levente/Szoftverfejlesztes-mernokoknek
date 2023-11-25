package com.unideb.sfm.Szoftverfejlesztesmernokoknek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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

    Movie movie_1 = new Movie() {
        {
            setTitle("Bambi");
            setCategories("Action");
            setRating(7);
            setOverview("Too much blood");
            setPoster_path("Test poster path 1");
            setYt_trailer_id("Test trailer id 1");
            setYear(2021);
        }
    };
    Movie movie_2 = new Movie() {
        {
            setTitle("Fast and Furious");
            setCategories("Drama");
            setRating(6);
            setOverview("A bit too long");
            setPoster_path("Test poster path 2");
            setYt_trailer_id("Test trailer id 2");
            setYear(2021);
        }
    };
    Movie movie_3 = new Movie() {
        {
            setTitle("Alien Isolation");
            setCategories("Sci-fi");
            setRating(8);
            setOverview("Very good and interesting");
            setPoster_path("Test poster path 3");
            setYt_trailer_id("Test trailer id 3");
            setYear(2021);
        }
    };

    public void getAllMovies_Succes() throws Exception {
        List<Movie> movies = new ArrayList<>(Arrays.asList(movie_1, movie_2, movie_3));
        Mockito.when(movierepository.findAll()).thenReturn(movies);
        mockMvc.perform(MockMvcRequestBuilders.get("../../../../../../main/resources/").contentType("data.json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("Bambi")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title", Matchers.is("Fast and Furious")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].title", Matchers.is("Alien Isolation")));
    }
}
