package com.unideb.sfm.Szoftverfejlesztesmernokoknek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;

@SpringBootTest
public class FoodTests {
    @Test
    void testFood() {
        Food food = new Food();
        food.setName("Pizza");
        food.setDescription("Pizza");
        food.setPrice(1000);
        food.setImage("pizza.jpg");
        assertEquals("Pizza", food.getName());
        assertEquals("Pizza", food.getDescription());
        assertEquals(1000, food.getPrice());
        assertEquals("pizza.jpg", food.getImage());
    }
}
