package edu.bilak.polymorphism.price;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class Price
 * @since 29/10/2024 — 13.39
 **/
public abstract class Price {
    public abstract double getRentalCost(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
