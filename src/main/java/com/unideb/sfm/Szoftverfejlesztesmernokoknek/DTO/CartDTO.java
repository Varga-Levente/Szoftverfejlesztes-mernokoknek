package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Cart;

public class CartDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("userId")
    private int userId; // Az User azonosítója
    @JsonProperty("foodId")
    private int foodId; // Az élelmiszer azonosítója
    @JsonProperty("quantity")
    private int quantity;

    public CartDTO() {}

    public CartDTO(int id, int userId, int foodId, int quantity) {
        this.id = id;
        this.userId = userId;
        this.foodId = foodId;
        this.quantity = quantity;
    }

    // Getterek és setterek

    public static CartDTO fromCart(Cart cart) {
        return new CartDTO(cart.getId(), cart.getUser().getId(), cart.getFood().getId(), cart.getQuantity());
    }
}
