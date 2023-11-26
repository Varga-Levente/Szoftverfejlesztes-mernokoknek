package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sfm_cinema")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;
}
