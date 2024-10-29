package edu.bilak.polymorphism;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class Customer
 * @since 29/10/2024 — 12.14
 **/
public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle()+ "\t" + rental.getRentalCost() + "\n";
        }

        result += "Amount owed is " + getTotalRentalCost() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    private double getTotalRentalCost() {
        return rentals.stream().mapToDouble(Rental::getRentalCost).sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}
