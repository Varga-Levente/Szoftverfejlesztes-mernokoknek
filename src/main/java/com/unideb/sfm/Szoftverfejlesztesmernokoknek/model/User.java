package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sfm_users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String email;
    private String pw_hash;
    private String pw_salt;
}
