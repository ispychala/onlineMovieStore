package com.take.movies.controller;

import com.take.movies.entity.Movie;
import com.take.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

}
