package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: Make this work with POST
    //Create a new user with get parameters
    //http://localhost:8080/api/v1/user/create?name=John%20Doe&email=john.doe%40sfm.com&password=8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
    @RequestMapping("/create")
    public String createUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
       // Check if name is null
        if(name == null || name.isEmpty()) {
            return "Név megadása kötelező.";
        }
        if (email == null || email.isEmpty()) {
            return "Email megadása kötelező.";
        }
        if (password == null || password.isEmpty()) {
            return "Jelszó megadása kötelező.";
        }

        // Check if email is already in use
        if (userRepository.existsByEmail(email)) {
            return "Ezzel az email címmel már regisztráltak.";
        }

        // Create a new user with the given parameters
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "Sikeres regisztráció.";
    }

    //TODO: In production this should be deleted
    //List all users except the password and make email unreadable like this: jo****@g****.com (Leave TLD and @ readable)
    //http://localhost:8080/api/v1/user/listAll
    @RequestMapping("/listAll")
    public Iterable<User> listAllUsers() {
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            String email = user.getEmail();
            String[] emailParts = email.split("@");
            String emailName = emailParts[0];
            String emailDomain = emailParts[1];
            String emailTLD = emailDomain.split("\\.")[1];
            String emailProvider = emailDomain.split("\\.")[0];
            //Make emailName unreadable with * chars between 1 and last char and make emailProvider unreadable with * chars between 1 and last char
            String emailHidden = emailName.charAt(0) + "*".repeat(emailName.length() - 2) + emailName.charAt(emailName.length() - 1) + "@" + emailProvider.charAt(0) + "*".repeat(emailProvider.length() - 2) + emailProvider.charAt(emailProvider.length() - 1) + "." + emailTLD;
            user.setEmail(emailHidden);
            user.setPassword("***PROTECTED***");
        }
        return users;
    }

    //Get user by id and
    //http://localhost:8080/api/v1/user/getById?id=1
    @RequestMapping("/getById")
    public User getUserById(@RequestParam int id) {
        User user = userRepository.findById(id).orElse(null);
        String email = user.getEmail();
        String[] emailParts = email.split("@");
        String emailName = emailParts[0];
        String emailDomain = emailParts[1];
        String emailTLD = emailDomain.split("\\.")[1];
        String emailProvider = emailDomain.split("\\.")[0];
        //Make emailName unreadable with * chars between 1 and last char and make emailProvider unreadable with * chars between 1 and last char
        String emailHidden = emailName.charAt(0) + "*".repeat(emailName.length() - 2) + emailName.charAt(emailName.length() - 1) + "@" + emailProvider.charAt(0) + "*".repeat(emailProvider.length() - 2) + emailProvider.charAt(emailProvider.length() - 1) + "." + emailTLD;
        user.setEmail(emailHidden);
        user.setPassword("***PROTECTED***");

        return user;
    }

    //Get user by email
    //http://localhost:8080/api/v1/user/getByEmail?email=john.doe%40sfm.com
    @RequestMapping("/getByEmail")
    public User getUserByEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        String[] emailParts = email.split("@");
        String emailName = emailParts[0];
        String emailDomain = emailParts[1];
        String emailTLD = emailDomain.split("\\.")[1];
        String emailProvider = emailDomain.split("\\.")[0];
        //Make emailName unreadable with * chars between 1 and last char and make emailProvider unreadable with * chars between 1 and last char
        String emailHidden = emailName.charAt(0) + "*".repeat(emailName.length() - 2) + emailName.charAt(emailName.length() - 1) + "@" + emailProvider.charAt(0) + "*".repeat(emailProvider.length() - 2) + emailProvider.charAt(emailProvider.length() - 1) + "." + emailTLD;
        user.setEmail(emailHidden);
        user.setPassword("***PROTECTED***");

        return user;
    }

    //Get user by name
    //http://localhost:8080/api/v1/user/getByName?name=John%20Doe
    @RequestMapping("/getByName")
    public User getUserByName(@RequestParam String name) {
        User user = userRepository.findByName(name);
        String email = user.getEmail();
        String[] emailParts = email.split("@");
        String emailName = emailParts[0];
        String emailDomain = emailParts[1];
        String emailTLD = emailDomain.split("\\.")[1];
        String emailProvider = emailDomain.split("\\.")[0];
        //Make emailName unreadable with * chars between 1 and last char and make emailProvider unreadable with * chars between 1 and last char
        String emailHidden = emailName.charAt(0) + "*".repeat(emailName.length() - 2) + emailName.charAt(emailName.length() - 1) + "@" + emailProvider.charAt(0) + "*".repeat(emailProvider.length() - 2) + emailProvider.charAt(emailProvider.length() - 1) + "." + emailTLD;
        user.setEmail(emailHidden);
        user.setPassword("***PROTECTED***");

        return user;
    }

    //TODO: This should be a DELETE request in production
    //Delete user by id
    //http://localhost:8080/api/v1/user/deleteById?id=1
    @RequestMapping("/deleteById")
    public String deleteUserById(@RequestParam int id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return "User deleted";
    }
}
