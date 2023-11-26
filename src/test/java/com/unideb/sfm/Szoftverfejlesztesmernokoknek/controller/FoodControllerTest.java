package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodService;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class FoodControllerTest {

    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(foodController).build();
    }

    @Test
    public void testGetFood() throws Exception {
        List<Food> foods = Arrays.asList(
                new Food(
                        null,
                        "hamburger",
                        "dupla husos",
                        3240,
                        "hambi.jpg"
                ),
                new Food(
                        null,
                        "pizza",
                        "magyaros",
                        2350,
                        "pizza.jpg"
                )
        );

        when(foodController.getAll()).thenReturn(foods);

        mockMvc.perform(get("/api/v1/food/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("hamburger"))
                .andExpect(jsonPath("$[1].name").value("pizza"));
    }

    /*@Test
    public void testAddFood() throws Exception {
        Food food = new Food(
                null,
                "pop-corn",
                "sos",
                1090,
                "sospop-corn.jpg"
        );

        List<Food> foodList = Collections.singletonList(food);

        when(foodService.addFoods(any())).thenAnswer(invocation -> {
            List<Food> addedFoods = invocation.getArgument(0);
            return ResponseEntity.ok("Food added successfully");
        });

        mockMvc.perform(post("/api/v1/food/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(foodList)))
                .andExpect(status().isOk())
                .andExpect(content().string("Food added successfully"));
    }*/
}
