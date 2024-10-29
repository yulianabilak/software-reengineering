package edu.bilak.polymorphism.price;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class RegularPrice
 * @since 29/10/2024 — 13.47
 **/
public class RegularPrice extends Price {
    @Override
    public double getRentalCost(int daysRented) {
        double rentalCost = 2;
        if (daysRented > 2) {
            rentalCost += (daysRented - 2) * 1.5;
        }
        return rentalCost;
    }
}
