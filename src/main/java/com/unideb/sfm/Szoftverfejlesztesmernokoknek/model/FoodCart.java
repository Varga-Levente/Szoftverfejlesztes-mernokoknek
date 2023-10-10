package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "sfm_food_cart")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FoodCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    @JoinColumn(name = "food_item_id")
    private List<FoodCartItem> foodCartItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public FoodCart(User user, List<FoodCartItem> foodCartItems) {
        setUser(user);
        setFoodCartItems(foodCartItems);
    }


    //Get foodcart items
    public List<FoodCartItem> getFoodCartItems() {
        return foodCartItems;
    }

    public void setFoodCartItems(List<FoodCartItem> foodCartItems) {
    }
}
