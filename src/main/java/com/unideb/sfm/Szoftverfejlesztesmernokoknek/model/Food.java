package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length = 1500)
    private String description;
    private int price;
    private String img_url;

    @ManyToOne // Egy User-hez tartozik
    @JoinColumn(name = "user_id") // Az "user_id" oszlop azonosítja a kapcsolatot
    private User user; // Ez az attribútum mutat az User entitásra

    public Food(String name, String description, int price, String img_url) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setImg_url(img_url);
    }

    public Food() {} // default empty constructor

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price && Objects.equals(id, food.id) && Objects.equals(name, food.name) && Objects.equals(description, food.description) && Objects.equals(img_url, food.img_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, img_url);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
