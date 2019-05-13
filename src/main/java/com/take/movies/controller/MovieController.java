package com.take.movies.controller;

import com.take.movies.dao.MovieRepository;
import com.take.movies.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
      //  movieRepository.getMoviesByGenre(genre);
        model.addAttribute("genres", genres);
        return "movies";
    }

    @PostMapping("/search")
    public String listByGenre(@ModelAttribute("movie") Movie movie, Model model) {
        if (movie.getCategory() != null) {
            List<Movie> movies = movieRepository.getMoviesByGenre(movie.getCategory());
            model.addAttribute("movies", movies);
        } else {
            model.addAttribute("movies", movieRepository.findAll());
        }
        model.addAttribute("genres", genres);
        return "movies";
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
