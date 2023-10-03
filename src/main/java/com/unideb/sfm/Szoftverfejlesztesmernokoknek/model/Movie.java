package com.unideb.sfm.Szoftverfejlesztesmernokoknek.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "project_movies")
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

    private String categories;

    @ManyToOne
    private CinemaRoom cinemaRoom;

    //Constructors
    public Movie(Integer id, String title, Integer year, double rating, String overview, String poster_path, String categories) {
        setId(id);
        setTitle(title);
        setYear(year);
        setRating(rating);
        setOverview(overview);
        setPoster_path(poster_path);
        setCategories(categories);
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
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", categories='" + categories + '\'' +
                ", cinemaRoom=" + cinemaRoom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.rating, rating) == 0 && Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(year, movie.year) && Objects.equals(overview, movie.overview) && Objects.equals(poster_path, movie.poster_path) && Objects.equals(categories, movie.categories) && Objects.equals(cinemaRoom, movie.cinemaRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, rating, overview, poster_path, categories, cinemaRoom);
    }

    // getters and setters and other add and remove methods
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getCategories() {
        return categories;
    }

    public void addCategory(String category) {
        this.categories += category+";";
    }

    public void removeCategory(String category) {
        this.categories = this.categories.replace(category+";", "");
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }
}