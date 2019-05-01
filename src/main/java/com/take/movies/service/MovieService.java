package com.take.movies.service;

import com.take.movies.dao.MovieDao;
import com.take.movies.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieDao movieDao;

    public List<Movie> getAllMovies() {
        return this.movieDao.findAll();
    }

    public Movie addMovie(Movie movie) {
        return this.movieDao.save(movie);
    }
}
