package com.take.movies.controller;

import com.take.movies.CurrencyConverter;
import com.take.movies.ShoppingCart;
import com.take.movies.dao.MovieRepository;
import com.take.movies.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private MovieRepository movieRepository;
    private ShoppingCart shoppingCart;
    private CurrencyConverter currencyConverter;

    private List<String> genres = Arrays.asList("DRAMA", "COMEDY", "FAMILY", "ACTION", "SCI-FI", "CLASSICS");
    public MovieController(MovieRepository movieRepository) {
        this.shoppingCart = new ShoppingCart();
        this.movieRepository = movieRepository;
        this.currencyConverter = CurrencyConverter.getInstance();
    }

    @GetMapping
    public String movies(Model model) {
        model.addAttribute(new Movie());
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("genres", genres);
        model.addAttribute("converter", currencyConverter);
        model.addAttribute("cart", shoppingCart);
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
        model.addAttribute("converter", currencyConverter);
        model.addAttribute("cart", shoppingCart);
        return "movies";
    }


    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String addToBasket(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie != null) {
            shoppingCart.addMovieToBasket(movie);
        }
        return "redirect:/movies";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String removeFromBasket(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie != null) {
            shoppingCart.removeMovieFromBasket(movie);
        }
        return "redirect:/movies";
    }
}
