package edu.bilak.polymorphism.price;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class NewReleasePrice
 * @since 29/10/2024 — 13.50
 **/
public class NewReleasePrice extends Price {
    @Override
    public double getRentalCost(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // Bonus point for new releases rented more than one day
        return (daysRented > 1) ? 2 : 1;
    }
}
