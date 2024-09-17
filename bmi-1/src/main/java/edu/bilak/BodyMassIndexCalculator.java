package edu.bilak;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project bmi-1
 * @class BodyMassIndexCalculator
 * @since 17/09/2024 — 11.44
 **/
public class BodyMassIndexCalculator {
    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 25.0;
    private static final double OVERWEIGHT_THRESHOLD = 30.0;

    private BodyMassIndexCalculator() {}

    private static double getBmi(double weightInKilograms, double heightInMeters) {
        if (weightInKilograms <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }
        if (heightInMeters <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weightInKilograms / (heightInMeters * heightInMeters);
    }

    public static String getBmiCategory(double weightInKilograms, double heightInMeters) {
        double bmi = getBmi(weightInKilograms, heightInMeters);
        if (bmi < UNDERWEIGHT_THRESHOLD) {
            return "Underweight";
        } else if (bmi < NORMAL_THRESHOLD) {
            return "Normal";
        } else if (bmi < OVERWEIGHT_THRESHOLD) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
