package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodCartRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodCartService {

    @Autowired
    private FoodCartRepository foodCartRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;

    public FoodCart addToCart(Integer foodId, Integer userId) {
        FoodCart foodCart = new FoodCart();
        Optional<Food> food = foodRepository.findById(foodId);
        Optional<User> user = userRepository.findById(userId);
        if (food.isPresent() && user.isPresent()) {
            foodCart.setFood(food.get());
            foodCart.setUser(user.get());
            foodCartRepository.save(foodCart);
        }
        return foodCart;
    }
}
