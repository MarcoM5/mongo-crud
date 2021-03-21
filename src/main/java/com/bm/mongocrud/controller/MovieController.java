package com.bm.mongocrud.controller;

import com.bm.mongocrud.model.Movie;
import com.bm.mongocrud.service.EntityNotFoundException;
import com.bm.mongocrud.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable String id) throws EntityNotFoundException {
        return movieService.getMovie(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.insertMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
    }

}
