package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Iterable<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food addFood(Food food) {
        return foodRepository.save(food);
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
}
