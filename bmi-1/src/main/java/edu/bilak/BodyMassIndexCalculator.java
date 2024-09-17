package edu.bilak;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project bmi-1
 * @class BodyMassIndexCalculator
 * @since 17/09/2024 — 11.44
 **/
public class BodyMassIndexCalculator {
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
        BmiCategory category = BmiCategory.fromBmi(bmi);
        return category.getDescription();
    }
}
