package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food addFood(Food food) {
        // Itt lehetőség van validálni az adatokat és további üzleti logikát végrehajtani
        return foodRepository.save(food);
    }

    public void removeFoodById(Long foodId) {
        foodRepository.deleteById(foodId);
    }

    // További szolgáltatás metódusok, például getFoodById, updateFood stb.
}

