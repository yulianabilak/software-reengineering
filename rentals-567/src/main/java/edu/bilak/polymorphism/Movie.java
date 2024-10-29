package edu.bilak.polymorphism;

import edu.bilak.polymorphism.price.Price;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class Movie
 * @since 29/10/2024 — 12.14
 **/
public class Movie {
    private final String title;
    private final Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle () {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public double getRentalCost(int daysRented) {
        return price.getRentalCost(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
