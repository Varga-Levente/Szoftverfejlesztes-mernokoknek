package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_movies")
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Integer id;
    private String title;
    @Column(name = "release_year")
    private Integer year;
    private double rating;

    public Movie(Integer id, String title, Integer year, double rating) {
        setId(id);
        setTitle(title);
        setYear(year);
        setRating(rating);
    }

    public Movie() {} // default empty constructor

//Utils
    public static String getTableName() {
        return "project_movies";
    }

    public static String getSequenceName() {
        return "movie_sequence";
    }

// Override toString, equals and hashCode
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + "'" +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(getId(), movie.getId()) && Objects.equals(getTitle(), movie.getTitle()) && Objects.equals(getYear(), movie.getYear()) && Objects.equals(getRating(), movie.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getYear(), getRating());
    }

// getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
