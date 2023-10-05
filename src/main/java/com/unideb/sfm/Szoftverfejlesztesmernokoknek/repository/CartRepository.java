package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Object findByUserId(int userId);

    List<Cart> findAllByUserId(int id);

    void deleteAllByUserId(int userId);
}
