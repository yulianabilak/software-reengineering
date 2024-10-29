package edu.bilak;

import edu.bilak.refactored.Customer;
import edu.bilak.refactored.Rental;
import org.junit.jupiter.api.Test;

import edu.bilak.refactored.Movie;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project rentals-567
 * @class CustomerTest
 * @since 19/10/2024 — 19.44
 **/
public class CustomerTest {
    private static final Movie REGULAR_MOVIE = new Movie("Regular Movie", Movie.MovieType.REGULAR);
    private static final Movie NEW_RELEASE_MOVIE = new Movie("New Release Movie", Movie.MovieType.NEW_RELEASE);
    private static final Movie CHILDRENS_MOVIE = new Movie("Children Movie", Movie.MovieType.CHILDRENS);

    @Test
    public void whenNoRentals_thenReturnZeroAmountAndPoints() {
        Customer customer = new Customer("John Doe", List.of());

        String expected = """
            Rental Record for John Doe
            Amount owed is 0.0
            You earned 0 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingRegularMovieForTwoDaysOrLess_thenStatementIncludesBaseCost() {
        Customer customer = new Customer("John Doe", List.of(new Rental(REGULAR_MOVIE, 2))); // base cost - 2

        String expected = """
            Rental Record for John Doe
            \tRegular Movie\t2.0
            Amount owed is 2.0
            You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingRegularMovieForMoreThanTwoDays_thenStatementIncludesExtraCost() {
        Customer customer = new Customer("John Doe", List.of(new Rental(REGULAR_MOVIE, 4))); // 2 + (4 - 2) * 1.5 = 5

        String expected = """
            Rental Record for John Doe
            \tRegular Movie\t5.0
            Amount owed is 5.0
            You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingNewReleaseMovieForOneDay_thenStatementIncludesCostWithoutBonusPoint() {
        Customer customer = new Customer("John Doe", List.of(new Rental(NEW_RELEASE_MOVIE, 1))); // 1 * 3 = 3

        String expected = """
            Rental Record for John Doe
            \tNew Release Movie\t3.0
            Amount owed is 3.0
            You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingNewReleaseMovieForMoreThanOneDay_thenStatementIncludesCostWithBonusPoint() {
        Customer customer = new Customer("John Doe", List.of(new Rental(NEW_RELEASE_MOVIE, 3))); // 3 * 3 = 9

        String expected = """
            Rental Record for John Doe
            \tNew Release Movie\t9.0
            Amount owed is 9.0
            You earned 2 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingChildrenMovieForThreeDaysOrLess_thenStatementIncludesBaseCost() {
        Customer customer = new Customer("John Doe", List.of(new Rental(CHILDRENS_MOVIE, 3))); // base cost - 1.5

        String expected = """
            Rental Record for John Doe
            \tChildren Movie\t1.5
            Amount owed is 1.5
            You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingChildrenMovieForMoreThanThreeDays_thenStatementIncludesExtraCost() {
        Customer customer = new Customer("John Doe", List.of(new Rental(CHILDRENS_MOVIE, 5))); // 1.5 + (5 - 3) * 1.5 = 4.5

        String expected = """
            Rental Record for John Doe
            \tChildren Movie\t4.5
            Amount owed is 4.5
            You earned 1 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingMoviesOfAllCategories_thenStatementIncludesCorrectCost() {
        Customer customer = new Customer("John Doe", List.of(
                new Rental(REGULAR_MOVIE, 4),      // Regular: 2 + (4 - 2) * 1.5 = 5
                new Rental(NEW_RELEASE_MOVIE, 2),  // New Release: 2 * 3 = 6
                new Rental(CHILDRENS_MOVIE, 5)     // Children's: 1.5 + (5 - 3) * 1.5 = 4.5
        ));

        String expected = """
            Rental Record for John Doe
            \tRegular Movie\t5.0
            \tNew Release Movie\t6.0
            \tChildren Movie\t4.5
            Amount owed is 15.5
            You earned 4 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenRentingMultipleMoviesOfSameCategory_thenStatementIncludesEachIndependentCost() {
        Customer customer = new Customer("John Doe", List.of(
           new Rental(REGULAR_MOVIE, 1), // Regular: 2
           new Rental(REGULAR_MOVIE, 3)  // Regular: 2 + (3 - 2) * 1.5 = 3.5
        ));

        String expected = """
            Rental Record for John Doe
            \tRegular Movie\t2.0
            \tRegular Movie\t3.5
            Amount owed is 5.5
            You earned 2 frequent renter points""";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void whenMixedLongAndShortRentals_thenStatementIncludesCorrectCost() {
        Customer customer = new Customer("John Doe", List.of(
                new Rental(REGULAR_MOVIE, 1),    // Regular: 2
                new Rental(CHILDRENS_MOVIE, 10)  // Children's: 1.5 + (10 - 3) * 1.5 = 12
        ));

        String expected = """
            Rental Record for John Doe
            \tRegular Movie\t2.0
            \tChildren Movie\t12.0
            Amount owed is 14.0
            You earned 2 frequent renter points""";

        assertEquals(expected, customer.statement());
    }
}
