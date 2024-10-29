package edu.bilak.polymorphism.price;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class ChildrenPrice
 * @since 29/10/2024 — 13.52
 **/
public class ChildrenPrice extends Price {
    @Override
    public double getRentalCost(int daysRented) {
        double rentalCost = 1.5;
        if (daysRented > 3) {
            rentalCost += (daysRented - 3) * 1.5;
        }
        return rentalCost;
    }
}
