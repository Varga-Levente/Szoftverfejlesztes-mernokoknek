package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer> {
    FoodCart findByUserId(Integer id);

    FoodCart findByUserAndFood(Optional<User> user, Optional<Food> food);

    void deleteByUserId(Integer userId);
}
