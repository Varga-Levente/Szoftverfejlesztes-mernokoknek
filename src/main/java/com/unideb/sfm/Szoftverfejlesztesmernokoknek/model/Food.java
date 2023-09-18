package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int price;
    private String img_url;

    public Food(Integer id, String name, int price, String img_url) {
        setId(id);
        setName(name);
        setPrice(price);
        setImg_url(img_url);
    }

    public Food() {} // default empty constructor

//Utils
    public static String getTableName() {
        return "project_food";
    }

    public static String getSequenceName() {
        return "food_sequence";
    }

// Override toString, equals and hashCode
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", price=" + price +
                ", img_url=" + img_url +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food food)) return false;
        return Objects.equals(getId(), food.getId()) && Objects.equals(getName(), food.getName()) && Objects.equals(getPrice(), food.getPrice()) && Objects.equals(getImg_url(), food.getImg_url());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getImg_url());
    }

// getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
