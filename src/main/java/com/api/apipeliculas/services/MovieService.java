package com.api.apipeliculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apipeliculas.models.Movie;
import com.api.apipeliculas.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(Long id) {
        return repository
                .findById(id).get();
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }
}
