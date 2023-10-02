package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
}
