package com.unideb.sfm.Szoftverfejlesztesmernokoknek.service;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public String removeUserById(Integer userId) {
        userRepository.deleteById(userId);
        return "User deleted";
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


    // További szolgáltatás metódusok, például getUserById, updateUser stb.
}

