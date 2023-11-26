package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testAddUser() {
        User userToAdd = new User();
        userToAdd.setUsername("testUser");
        userToAdd.setEmail("test@example.com");
        userToAdd.setPassword("testPassword");

        when(userService.addUser(Mockito.any()))
                .thenReturn(userToAdd);

        User result = userController.addUser(userToAdd);

        assertEquals(userToAdd, result);
    }

    @Test
    public void testGetAllUsers() {
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User("User numero1", "User1", "user1@example.com", "password1", null));
        mockUsers.add(new User("User numero2", "User2", "user2@example.com", "password2", null));

        when(userService.getAll())
                .thenReturn(mockUsers);

        Iterable<User> result = userController.getAll();

        assertEquals(mockUsers, result);
    }
}