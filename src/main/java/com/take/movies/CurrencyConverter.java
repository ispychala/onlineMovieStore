package com.take.movies;

public class CurrencyConverter {

    private CurrencyConverter() {}

    public static CurrencyConverter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CurrencyConverter INSTANCE = new CurrencyConverter();
    }

    private double eur = 4.26;

    public double convertToEur(double pln) {
        return this.eur * pln;
    }
}
