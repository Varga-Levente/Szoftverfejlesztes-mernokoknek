package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Cart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.CartRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.ReservationRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cart")
public class CartController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final FoodRepository foodRepository;
    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final CartRepository cartRepository;

    public CartController(UserRepository userRepository, FoodRepository foodRepository, ReservationRepository reservationRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
        this.reservationRepository = reservationRepository;
        this.cartRepository = cartRepository;
    }

    //Add food to food cart in user entity foodCart list
    //http://localhost:8080/api/v1/cart/addFoodToCart?userId=1&foodId=1
    @Transactional
    @RequestMapping("/addFoodToCart")
    public String addFoodToCart(@RequestParam int userId, @RequestParam int foodId) {
        // Felhasználóhoz hozzáad egy ételt a kosarához
        User user = userRepository.findById(userId).orElse(null);
        Food food = foodRepository.findById(foodId);
        if (food == null) {
            return "Nincs ilyen étel az adatbázisban.";
        }
        //Check if food is already in cart and if it is, increase quantity by 1
        List<Cart> cartItems = cartRepository.findAllByUserId(userId);
        for (Cart cartItem : cartItems) {
            if (cartItem.getFood().getId() == foodId) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartRepository.save(cartItem);
                return "Sikeresen hozzáadva a kosárhoz.";
            }
        }
        //If food is not in cart, create new cart item
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setFood(food);
        cart.setQuantity(1);
        cartRepository.save(cart);

        return "Sikeresen hozzáadva a kosárhoz.";
    }

    //Clear food cart in user entity foodCart list
    //http://localhost:8080/api/v1/cart/clearFoodCart?userId=1
    @Transactional
    @RequestMapping("/clearFoodCart")
    public String clearFoodCart(@RequestParam int userId) {
        // Felhasználó kosarának kiürítése
        List<Cart> cartItems = cartRepository.findAllByUserId(userId);
        //Delete all foods from cart
        for (Cart cartItem : cartItems) {
            cartRepository.delete(cartItem);
        }

        return "Sikeresen kiürítve a kosár.";
    }
}
