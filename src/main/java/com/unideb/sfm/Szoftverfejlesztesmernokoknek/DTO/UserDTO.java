package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private List<CartDTO> cartItems;
    private String password;

    public UserDTO() {}

    public UserDTO(int id, String name, String email, List<CartDTO> cartItems, String password) {
        setId(id);
        setName(name);
        setEmail(email);
        setCartItems(cartItems);
        setPassword(password);
    }

    // Getterek és setterek


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CartDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDTO fromUser(User user) {
        List<CartDTO> cartDTOs = user.getCartItems().stream()
                .map(CartDTO::fromCart)
                .collect(Collectors.toList());

        return new UserDTO(user.getId(), user.getName(), user.getEmail(), cartDTOs, user.getPassword());
    }
}
