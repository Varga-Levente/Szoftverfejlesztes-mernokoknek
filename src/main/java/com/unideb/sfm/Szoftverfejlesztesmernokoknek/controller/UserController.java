package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO.UserDTO;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodCartRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        User user = userRepository.findById(id).get();
        //Use UserDTO instead of User
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        //Get the foodCart by the user's id
        userDTO.setFoodCart(foodCartRepository.findByUserId(id));

        return userDTO;
    }

    @GetMapping("getAll")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    // További végpontok, például getUserById, updateUser stb.
}
