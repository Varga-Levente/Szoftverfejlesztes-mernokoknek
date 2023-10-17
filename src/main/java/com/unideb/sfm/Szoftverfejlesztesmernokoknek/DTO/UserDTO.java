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
    private String pw_hash;
    private String pw_salt;

    private List<FoodCartDTO> foodCarts;

}
