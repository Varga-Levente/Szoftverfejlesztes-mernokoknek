package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Food;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository.FoodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/food")
public class FoodController {
    private final FoodRepository foodRepository;
    private EntityManager entityManager;

    public FoodController(FoodRepository foodRepository, EntityManager entityManager) {
        this.foodRepository = foodRepository;
        this.entityManager = entityManager;
    }

    //RESET
    @Transactional
    @RequestMapping("/reset")
    public String reset() {
        foodRepository.deleteAll();

        //Reset the auto increment id in mariadb
        Query query = entityManager.createNativeQuery("ALTER TABLE project_food AUTO_INCREMENT = 1");
        query.executeUpdate();

        //Add 5 foods
        Food popcorn = new Food();
        popcorn.setName("Popcorn");
        popcorn.setDescription("Very tasty popcorn");
        popcorn.setPrice(1000);
        popcorn.setImg_url("");

        Food nacho = new Food();
        nacho.setName("Nacho");
        nacho.setDescription("Very tasty nacho");
        nacho.setPrice(1000);
        nacho.setImg_url("");

        Food hotdog = new Food();
        hotdog.setName("Hotdog");
        hotdog.setDescription("Very tasty hotdog");
        hotdog.setPrice(1000);
        hotdog.setImg_url("");

        Food hamburger = new Food();
        hamburger.setName("Hamburger");
        hamburger.setDescription("Very tasty hamburger");
        hamburger.setPrice(1000);
        hamburger.setImg_url("");

        Food chips = new Food();
        chips.setName("Chips");
        chips.setDescription("Very tasty chips");
        chips.setPrice(1000);
        chips.setImg_url("");

        foodRepository.save(popcorn);
        foodRepository.save(nacho);
        foodRepository.save(hotdog);
        foodRepository.save(hamburger);
        foodRepository.save(chips);

        return "Added 5 foods to the database.";
    }

    //URL: http://localhost:8080/api/v1/food/listAllFoods
    @RequestMapping("/listAllFoods")
    public Iterable<Food> listAllFoods() {
        Iterable<Food> foods = foodRepository.findAll();
        return foods;
    }

    @PostMapping("/addFood")
    public String addFood(Food food) {
        foodRepository.save(food);
        return "Sikeresen hozzáadva.";
    }

    @DeleteMapping("/deleteFoodById")
    public String deleteFoodById(@RequestParam int id) {
        foodRepository.deleteById(id);
        return "Sikeresen törölve.";
    }

    @PutMapping("/updateFoodById")
    public String updateFoodById(@RequestParam int id, Food food) {
        foodRepository.updateFoodById(id, food.getName(), food.getDescription(), food.getPrice(), food.getImg_url());
        return "Sikeresen módosítva.";
    }
}
