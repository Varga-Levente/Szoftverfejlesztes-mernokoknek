package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "sfm_project_movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotNull(message = "Title cannot be null")
    private String title;

    //@NotNull(message = "Title cannot be null")
    @Column(name = "release_year")
    private Integer year;

    //@NotNull(message = "Title cannot be null")
    private double rating;

    @Column(name="overview", length=2048)
    private String overview;

    private String poster_path;

    private String yt_trailer_id;

    private String categories;
}