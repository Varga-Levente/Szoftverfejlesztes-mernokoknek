package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sfm_food_cart_item")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FoodCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private Integer quantity;

    public FoodCartItem(Food food) {
        setFood(food);
    }
}
