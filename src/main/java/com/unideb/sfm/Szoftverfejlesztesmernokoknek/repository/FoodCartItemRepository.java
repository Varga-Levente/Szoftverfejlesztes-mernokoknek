package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartItemRepository extends JpaRepository<FoodCartItem, Integer> {
}
