package com.bm.mongocrud.dataaccessobject;

import com.bm.mongocrud.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class MovieDao {

    private static Logger LOG = LoggerFactory.getLogger(MovieDao.class);

    private final MovieRepository movieRepository;

    public MovieDao(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

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
            LOG.warn("Movie not Found: {}", id);
        }
    }

}
