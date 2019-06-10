package com.take.movies;

import com.take.movies.entity.Movie;

import javax.persistence.Entity;
import java.util.*;

public class ShoppingCart {

    private Set<Movie> cart;

    public ShoppingCart() {
        this.cart = new LinkedHashSet<>();
    }

    public Set<Movie> getCart() {
        return cart;
    }

    public void addMovieToBasket(Movie m) {
        System.out.println("adding: " + m.getTitle());
        this.cart.add(m);
    }

    public void removeMovieFromBasket(Movie m) {
        Iterator<Movie> it = cart.iterator();
        while (it.hasNext()) {
            Movie tmpM = it.next();
            if (tmpM.getId() == m.getId()) {
                it.remove();
                break;
            }
        }
    }

    public double cartTotal() {
        double total = 0.0;
        for (Movie m : cart) {
            total += m.getPrice();
        }
        return total;
    }
}
