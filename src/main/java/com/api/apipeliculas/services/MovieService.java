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
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Movie not found with id: " + id));
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie updateMovie(Movie request, Long id) {
        Movie existingMovie = repository.findById(id).get();
        if (request.getTitle() != null || !request.getTitle().isBlank()) {
            existingMovie.setTitle(request.getTitle());
        }
        if (request.getDescription() != null || !request.getDescription().isBlank()) {
            existingMovie.setDescription(request.getDescription());
        }
        if (request.getImageUrl() != null || !request.getImageUrl().isBlank()) {
            existingMovie.setImageUrl(request.getImageUrl());
        }
        if (request.getRating() != null || request.getRating() > 0) {
            existingMovie.setRating(request.getRating());
        }
        if (request.getYear() != null || request.getYear() > 0) {
            existingMovie.setYear(request.getYear());
        }
        return repository.save(existingMovie);
    }

    public Movie deleteMovie(Long id) {
        Movie movie = getMovieById(id);
        repository.delete(movie);
        return movie;
    }

}
