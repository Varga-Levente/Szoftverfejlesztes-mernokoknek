package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer> {
    FoodCart findByUserId(Integer id);

    void deleteByUserId(Integer userId);

    List<FoodCart> findAllByUserId(Integer id);

    List<FoodCart> findAllByUser(User user);
}
