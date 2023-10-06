package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @DeleteMapping("/removeFoodById/{foodId}")
    public void removeFoodById(@PathVariable Long foodId) {
        foodService.removeFoodById(foodId);
    }

    // További végpontok, például getFoodById, updateFood stb.
}
