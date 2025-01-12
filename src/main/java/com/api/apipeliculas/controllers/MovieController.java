package com.api.apipeliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.apipeliculas.models.Movie;
import com.api.apipeliculas.services.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return service.getMovieById(id);
    }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }
}
