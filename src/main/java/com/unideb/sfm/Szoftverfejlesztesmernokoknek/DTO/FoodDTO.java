package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private String image;
}
