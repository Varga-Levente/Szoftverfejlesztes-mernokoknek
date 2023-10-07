package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodCartRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
        Optional<User> user = userRepository.findById(userId);
        Optional<Food> food = foodRepository.findById(foodId);
        FoodCart foodCart = foodCartRepository.findByUserAndFood(user, food);
        if (foodCart == null) {
            foodCart = new FoodCart();
            foodCart.setUser(user.get());
            foodCart.setFood(food.get());
            foodCart.setQuantity(1);
        }
        if (food != null) {
            //Check if food is already in cart and if it is, increase the quantity
            foodCart.setQuantity(foodCart.getQuantity() + 1);
        }
        return foodCartRepository.save(foodCart);
    }

    //Clear cart by user id
    public String clearCart(Integer userId) {
        foodCartRepository.deleteByUserId(userId);
        return "Cart cleared";
    }
}
