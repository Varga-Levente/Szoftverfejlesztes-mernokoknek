package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FoodControllerTest {

    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;

    @Test
    public void testGetAll() {
        // Arrange
        List<Food> mockFoods = new ArrayList<>();
        mockFoods.add(new Food(1, "Pizza", "Delicious", 10, "pizza.jpg"));
        mockFoods.add(new Food(2, "Burger", "Tasty", 8, "burger.jpg"));

        when(foodService.getAll()).thenReturn(mockFoods);

        // Act
        Iterable<Food> result = foodController.getAll();

        // Assert
        assertEquals(mockFoods, result);
    }

    @Test
    public void testAddFood() {
        // Arrange
        List<Food> mockFoodsToAdd = new ArrayList<>();
        mockFoodsToAdd.add(new Food(1, "Pizza", "Delicious", 10, "pizza.jpg"));
        mockFoodsToAdd.add(new Food(2, "Burger", "Tasty", 8, "burger.jpg"));

        when(foodService.addFoods(mockFoodsToAdd)).thenReturn(mockFoodsToAdd);

        // Act
        List<Food> result = foodController.addFood(mockFoodsToAdd);

        // Assert
        assertEquals(mockFoodsToAdd, result);
    }
}