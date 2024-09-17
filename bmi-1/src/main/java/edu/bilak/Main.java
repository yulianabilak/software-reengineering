package edu.bilak;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project bmi-1
 * @class Main
 * @since 17/09/2024 — 19.15
 **/
public class Main {
    public static void main(String[] args) {
        try {
            String bmiCategory = BodyMassIndexCalculator.getBmiCategory(80, 1.52);
            System.out.println("BMI Category: " + bmiCategory);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
