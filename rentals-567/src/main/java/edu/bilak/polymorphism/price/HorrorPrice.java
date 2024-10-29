package edu.bilak.polymorphism.price;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class HorrorPrice
 * @since 26/11/2024 — 14.16
 **/
public class HorrorPrice extends Price {
    @Override
    public double getRentalCost(int daysRented) {
        double rentalCost = 3;
        if (daysRented > 7) {
            rentalCost += (daysRented - 7) * 2;
        }
        return rentalCost;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // Bonus frequent renter point for horror movies rented more than 3 days
        return daysRented > 3 ? 2 : 1;
    }
}
