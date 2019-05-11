package com.take.movies.controller;

import com.take.movies.dao.MovieRepository;
import com.take.movies.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private MovieRepository movieRepository;

    private List<String> genres = Arrays.asList("DRAMA", "COMEDY", "FAMILY", "ACTION", "SCI-FI", "CLASSICS");
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public String movies(Model model) {
        model.addAttribute(new Movie());
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("genres", genres);
        return "movies";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
