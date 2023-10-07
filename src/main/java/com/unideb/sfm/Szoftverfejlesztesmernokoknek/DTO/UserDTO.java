package com.unideb.sfm.Szoftverfejlesztesmernokoknek.DTO;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.FoodCart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;

    private String fullName;
    private String email;
    private String password;

    private FoodCart foodCart;

}
