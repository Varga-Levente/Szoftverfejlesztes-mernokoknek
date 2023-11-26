package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
    public List<Food> addFood(@RequestBody List<Food> foods) {
        return foodService.addFoods(foods);
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

    @PutMapping("edit/{foodId}")
    //Create an edit endpoint for the food
    //There is a path variable in the url, which is the id of the food
    //Get the food by the id and set the new values
    //Return 200 OK if the edit was successful
    public ResponseEntity<?> editFoodById(@PathVariable("foodId") Integer foodId, @RequestBody Food food) {
        return foodService.editFoodById(foodId, food);
    }

}
