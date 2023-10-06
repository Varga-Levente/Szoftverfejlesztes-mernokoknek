package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.CartItem;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/removeUserById/{userId}")
    public void removeUserById(@PathVariable Long userId) {
        userService.removeUserById(userId);
    }

    @PostMapping("/addItemToCart/{userId}")
    public User addItemToCart(@PathVariable Long userId, @RequestBody CartItem cartItem) {
        return userService.addItemToCart(userId, cartItem);
    }

    @PostMapping("/{userId}/addFoodToCartById")
    public User addFoodToCartById(@PathVariable Long userId, @RequestParam Long foodId) {
        return userService.addFoodByIdToUserCart(userId, foodId);
    }

    // További végpontok, például getUserById, updateUser stb.
}
