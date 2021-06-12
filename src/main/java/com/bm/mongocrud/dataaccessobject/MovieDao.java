package com.bm.mongocrud.dataaccessobject;

import com.bm.mongocrud.model.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MovieDao {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    public Movie insertMovie(Movie movie) {
        return movieRepository.insert(movie);
    }

//    public Movie updateMovie(Movie movie) {
//        final Optional<Movie> oldMovie = movieRepository.findById(movie.getId());
//        oldMovie.ifPresent() {
//            oldMovie.
//        } else {
//            movieRepository.insert(movie);
//        }
//
//    }

    public void deleteMovie(String id) {
        try {
            movieRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            log.warn("Movie not Found: {}", id);
        }
    }

}
