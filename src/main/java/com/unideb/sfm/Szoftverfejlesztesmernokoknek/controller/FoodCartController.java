package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foodCart")
public class FoodCartController {

    @Autowired
    private FoodCartService foodCartService;

    @GetMapping("/addToCart/{userId}/{foodId}")
    public FoodCart addToCart(@PathVariable("foodId") Integer foodId, @PathVariable("userId") Integer userId) {
        return foodCartService.addToCart(foodId, userId);
    }
}
