package com.api.apipeliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        try {
            return ResponseEntity
            .ok(service.getMovieById(id));
        } catch (RuntimeException e) {
            return ResponseEntity
            .badRequest()
            .body(e.getMessage());
        }
    }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@RequestBody Movie request, @PathVariable Long id) {
        return service.updateMovie(request, id);
    }

    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable Long id) {
        return service.deleteMovie(id);
    }
}
