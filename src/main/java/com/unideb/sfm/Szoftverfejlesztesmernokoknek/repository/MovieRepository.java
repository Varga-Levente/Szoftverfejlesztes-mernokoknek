package com.unideb.sfm.Szoftverfejlesztesmernokoknek.repository;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
