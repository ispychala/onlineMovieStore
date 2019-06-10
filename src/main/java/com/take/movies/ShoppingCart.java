package com.take.movies;

import com.take.movies.entity.Movie;

import javax.persistence.Entity;
import java.util.*;

public class ShoppingCart {

    private Set<Movie> cart;

    public ShoppingCart() {
        this.cart = new LinkedHashSet<>();
    }

    /*public static ShoppingCart getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ShoppingCart INSTANCE = new ShoppingCart();
    }
*/
    public Set<Movie> getCart() {
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
