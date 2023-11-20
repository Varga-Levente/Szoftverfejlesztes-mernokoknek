package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Iterable<Food> getAll() {
        return foodRepository.findAll();
    }

    public List<Food> addFoods(List<Food> foods) {
        return (List<Food>) foodRepository.saveAll(foods);
    }


    public String removeFoodById(Integer foodId) {
        foodRepository.deleteById(foodId);
        return "Food deleted";
    }

    public String removeAll() {
        foodRepository.deleteAll();
        return "All food deleted";
    }

    public Food getFoodById(Integer foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

    public ResponseEntity<?> editFoodById(Integer foodId, Food food) {
        Food existingFood = foodRepository.findById(foodId).orElse(null);
        //If the food does not exist, return 404 Not found
        if (existingFood == null) {
            return ResponseEntity.notFound().build();
        }

        //If food is null, return 400 Bad Request
        if (food == null) {
            return ResponseEntity.badRequest().build();
        }

        //Change the values of the existing food to the new values
        existingFood.setName(food.getName());
        existingFood.setPrice(food.getPrice());
        existingFood.setDescription(food.getDescription());
        existingFood.setImage(food.getImage());

        //Save the existing food
        foodRepository.save(existingFood);
        return ResponseEntity.ok("Food edited");
    }

}
