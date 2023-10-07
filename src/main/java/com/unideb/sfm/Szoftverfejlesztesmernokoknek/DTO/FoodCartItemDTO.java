package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCartItemDTO {
    Integer id;
    private FoodDTO food;
    private Integer quantity;
}
