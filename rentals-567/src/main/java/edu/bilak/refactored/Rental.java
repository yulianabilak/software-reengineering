package edu.bilak.refactored;

import static edu.bilak.refactored.Movie.MovieType.NEW_RELEASE;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class Rental
 * @since 29/10/2024 — 10.25
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
        double rentalCost = 0;
        //determine amounts for each line
        switch (getMovie().getPriceCode()) {
            case REGULAR -> {
                rentalCost += 2;
                if (getDaysRented() > 2)
                    rentalCost += (getDaysRented() - 2) * 1.5;
            }
            case NEW_RELEASE -> rentalCost += getDaysRented() * 3;
            case CHILDRENS -> {
                rentalCost += 1.5;
                if (getDaysRented() > 3)
                    rentalCost += (getDaysRented() - 3) * 1.5;
            }
        }
        return rentalCost;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
