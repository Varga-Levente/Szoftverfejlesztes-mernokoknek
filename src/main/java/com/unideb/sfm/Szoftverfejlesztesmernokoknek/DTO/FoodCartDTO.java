package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodCartDTO {
    private Integer id;
    private List<FoodCartItemDTO> foodCartItems;
}
