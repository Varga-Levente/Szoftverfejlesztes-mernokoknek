package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sfm_food_cart")
@Getter
@Setter
@NoArgsConstructor
public class FoodCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Food food;

    @OneToOne
    private User user;

    public FoodCart(Food food, User user) {
        setFood(food);
        setUser(user);
    }
}
