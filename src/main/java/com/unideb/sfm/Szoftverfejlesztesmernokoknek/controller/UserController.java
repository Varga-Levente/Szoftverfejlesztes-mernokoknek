package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO.FoodCartDTO;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO.FoodCartItemDTO;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO.FoodDTO;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO.UserDTO;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCartItem;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodCartRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodCartRepository foodCartRepository;

    private UserDTO userDTO;

    @PostMapping("add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("remove/{userId}")
    public String removeUserById(@PathVariable Integer userId) {
        return userService.removeUserById(userId);
    }

    @GetMapping("getById/{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        List<FoodCart> foodCarts = foodCartRepository.findAllByUser(user);
        List<FoodCartDTO> foodCartDTOs = new ArrayList<>();

        for (FoodCart foodCart : foodCarts) {
            FoodCartDTO foodCartDTO = new FoodCartDTO();
            foodCartDTO.setId(foodCart.getId());

            List<FoodCartItem> foodCartItems = foodCart.getFoodCartItems();
            List<FoodCartItemDTO> foodCartItemDTOs = new ArrayList<>();

            for (FoodCartItem foodCartItem : foodCartItems) {
                FoodCartItemDTO foodCartItemDTO = new FoodCartItemDTO();
                foodCartItemDTO.setId(foodCartItem.getId());

                FoodDTO foodDTO = new FoodDTO();
                foodDTO.setId(foodCartItem.getFood().getId());
                foodDTO.setName(foodCartItem.getFood().getName());
                foodDTO.setDescription(foodCartItem.getFood().getDescription());
                foodDTO.setPrice(foodCartItem.getFood().getPrice());
                foodDTO.setImage(foodCartItem.getFood().getImage());

                foodCartItemDTO.setFood(foodDTO);
                foodCartItemDTO.setQuantity(foodCartItem.getQuantity());
                foodCartItemDTOs.add(foodCartItemDTO);
            }

            foodCartDTO.setFoodCartItems(foodCartItemDTOs);
            foodCartDTOs.add(foodCartDTO);
        }

        userDTO.setFoodCarts(foodCartDTOs);

        return userDTO;
    }

    @GetMapping("getAll")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    // További végpontok, például getUserById, updateUser stb.
}
