package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("getAll")
    public Iterable<Food> getAll() {
        return foodService.getAll();
    }

    @PostMapping("add")
    public Food addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @DeleteMapping("remove/{foodId}")
    public String removeFoodById(@PathVariable("foodId") Integer foodId) {
        return foodService.removeFoodById(foodId);
    }

    @DeleteMapping("removeAll")
    public String removeAll() {
        return foodService.removeAll();
    }

    @GetMapping("getById/{foodId}")
    public Food getFoodById(@PathVariable("foodId") Integer foodId) {
        return foodService.getFoodById(foodId);
    }

}
