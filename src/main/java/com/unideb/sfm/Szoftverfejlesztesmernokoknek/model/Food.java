package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sfm_food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private Integer price;
    private String image;

}
