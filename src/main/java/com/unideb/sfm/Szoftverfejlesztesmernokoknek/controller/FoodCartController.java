package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodCartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/foodCart")
public class FoodCartController {

    @Autowired
    private FoodCartService foodCartService;

    @GetMapping("/addToCart/{userId}/{foodId}")
    public String addToCart(@PathVariable("foodId") Integer foodId, @PathVariable("userId") Integer userId) {
        return foodCartService.addToCart(foodId, userId);
    }

    @Transactional
    @DeleteMapping("/clearCart/{userId}")
    public String clearCart(@PathVariable("userId") Integer userId) {
        return foodCartService.clearCart(userId);
    }
}
