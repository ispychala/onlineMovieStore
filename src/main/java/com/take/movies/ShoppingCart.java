package com.take.movies;

import com.take.movies.entity.Movie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ShoppingCart {

    private HashSet<Movie> cart;

    public ShoppingCart() {
        this.cart = new HashSet<>();
    }

    public HashSet<Movie> getCart() {
        return cart;
    }

    public List<Movie> getCartAsList() {
        return new ArrayList<Movie>(this.cart);
    }

    public void addMovieToBasket(Movie m) {
        System.out.println("adding: " + m.getTitle());
        this.cart.add(m);
    }

    public void removeMovieFromBasket(Movie m) {
        this.cart.remove(m);
    }

    public double cartTotal() {
        double total = 0.0;
        for (Movie m : cart) {
            total += m.getPrice();
        }
        return total;
    }
}
