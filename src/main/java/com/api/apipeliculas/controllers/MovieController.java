package com.api.apipeliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
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
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Movie movieSave = service.saveMovie(movie);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie request, @PathVariable Long id) {
        try {
            Movie movieChange = service.updateMovie(request, id);
            return ResponseEntity
                    .ok(movieChange);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .ok(service.deleteMovie(id));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
