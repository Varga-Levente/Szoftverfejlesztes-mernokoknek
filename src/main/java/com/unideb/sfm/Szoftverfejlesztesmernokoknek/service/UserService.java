package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.exceptions.NotFoundException;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.CartItem;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    public User addUser(User user) {
        // Itt lehetőség van validálni az adatokat és további üzleti logikát végrehajtani
        return userRepository.save(user);
    }

    public void removeUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User addItemToCart(Long userId, CartItem cartItem) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        user.getCart().add(cartItem);
        // Itt lehetőség van további üzleti logikát hozzáadni a kosárhoz
        return userRepository.save(user);
    }

    public User addFoodByIdToUserCart(Long userId, Long foodId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new NotFoundException("Food not found with id: " + foodId));

        // Hozzáadja a Food elemet a felhasználó kosarához
        CartItem cartItem = new CartItem(user, food);
        user.getCart().add(cartItem);

        return userRepository.save(user);
    }


    // További szolgáltatás metódusok, például getUserById, updateUser stb.
}

