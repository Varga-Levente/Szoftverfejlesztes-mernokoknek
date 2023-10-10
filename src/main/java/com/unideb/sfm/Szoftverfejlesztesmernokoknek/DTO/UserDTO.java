package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private int id;

    private String fullName;
    private String email;
    private String password;

    private List<FoodCartDTO> foodCarts;

}
