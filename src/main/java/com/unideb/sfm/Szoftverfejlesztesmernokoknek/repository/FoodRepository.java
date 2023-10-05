package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    Food findById(long id);

    //Columns [name description price img_url]
    @Modifying
    @Query("update Food f set f.name = :name, f.description = :description, f.price = :price, f.img_url = :img_url where f.id = :id")
    void updateFoodById(@Param("id") long id, @Param("name") String name, @Param("description") String description, @Param("price") int price, @Param("img_url") String img_url);

    //Reset auto increment
    @Modifying
    @Query(value = "ALTER TABLE project_food AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
