package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCartItem;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodCartItemRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodCartRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodCartService {

    @Autowired
    private FoodCartRepository foodCartRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodCartItemRepository foodCartItemRepository;

    public String addToCart(Integer userId, Integer foodId) {
        // If user or food id is null or negative
        if (userId == null || foodId == null || userId < 0 || foodId < 0) {
            return null;
        }
        System.out.println("User id: " + userId + " Food id: " + foodId);

        // If user or food not found
        User user = userRepository.findById(userId).orElse(null);
        Food food = foodRepository.findById(foodId).orElse(null);
        if (user == null || food == null) {
            return null;
        }
        System.out.println("User: " + user + " Food: " + food);

        // Find the user's food cart
        FoodCart foodCart = foodCartRepository.findByUserId(userId);
        System.out.println("0|FoodCart: " + foodCart);

        if (foodCart != null) {
            // Check if the food item is already in the cart
            List<FoodCartItem> foodCartItems = foodCart.getFoodCartItems();

            boolean found = false;

            for (FoodCartItem item : foodCartItems) {
                if (item.getFood().getId() == foodId) {
                    // If the food item is already in the cart, increment its quantity
                    item.setQuantity(item.getQuantity() + 1);
                    foodCartItemRepository.save(item);
                    found = true;
                    break;
                }
            }

            if (!found) {
                // If the food item is not in the cart, create a new FoodCartItem
                FoodCartItem foodCartItem = new FoodCartItem(food);
                foodCartItem.setQuantity(1);
                foodCartItemRepository.save(foodCartItem);
                foodCartItems.add(foodCartItem);
                foodCart.setFoodCartItems(foodCartItems);
                foodCartRepository.save(foodCart);
            }

            System.out.println("1|FoodCart: " + foodCart);
            return foodCart.toString();
        } else {
            // If user has no cart, create a new FoodCart and add the FoodCartItem
            FoodCartItem foodCartItem = new FoodCartItem(food);
            foodCartItem.setQuantity(1);
            foodCartItemRepository.save(foodCartItem);
            List<FoodCartItem> foodCartItems = new ArrayList<>();
            foodCartItems.add(foodCartItem);
            FoodCart foodcart = new FoodCart(user, foodCartItems);
            System.out.println("2|FoodCart: " + foodcart);
            return foodCartRepository.save(foodcart).toString();
        }
    }

    //Clear cart by user id
    public String clearCart(Integer userId) {
        foodCartRepository.deleteByUserId(userId);
        return "Cart cleared";
    }
}
