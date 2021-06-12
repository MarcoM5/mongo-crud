package com.bm.mongocrud.service;

import com.bm.mongocrud.dataaccessobject.MovieDao;
import com.bm.mongocrud.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieDao movieDao;

    public List<Movie> getAllMovies() {
        return movieDao.getMovies();
    }

    public Movie getMovie(String id) throws EntityNotFoundException {
        final Optional<Movie> movie = movieDao.getMovieById(id);
        return movie.orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
    }

    public Movie insertMovie(Movie movie) {
        return movieDao.insertMovie(movie);
    }

    public void deleteMovie(String id) {
        movieDao.deleteMovie(id);
    }
}
