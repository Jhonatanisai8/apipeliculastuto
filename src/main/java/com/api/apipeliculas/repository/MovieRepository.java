package com.api.apipeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.apipeliculas.models.Movie;

public interface MovieRepository
        extends JpaRepository<Movie, Long> {

}