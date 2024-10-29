package edu.bilak.refactored;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class Movie
 * @since 29/10/2024 — 10.25
 **/
public class Movie {
    private final String title;
    private final MovieType priceCode;
    public enum MovieType {
        REGULAR, NEW_RELEASE, CHILDRENS
    }

    public Movie(String title, MovieType priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle (){
        return title;
    }
}
