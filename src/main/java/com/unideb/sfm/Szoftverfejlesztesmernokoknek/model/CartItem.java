package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sfm_cart_items")
@Data
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public CartItem(User user, Food food) {
        this.user = user;
        this.food = food;
    }

    public CartItem(User user, Reservation reservation) {
        this.user = user;
        this.reservation = reservation;
    }
}