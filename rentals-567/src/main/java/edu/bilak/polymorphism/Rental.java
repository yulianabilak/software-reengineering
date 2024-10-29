package edu.bilak.polymorphism;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class Rental
 * @since 29/10/2024 — 12.14
 **/
public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getRentalCost() {
        return movie.getRentalCost(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
