package edu.bilak;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project bmi-1
 * @class BmiCategory
 * @since 17/09/2024 — 22.27
 **/
public enum BmiCategory {
    UNDERWEIGHT(0, 18.5, "Underweight"),
    NORMAL(18.5, 25, "Normal"),
    OVERWEIGHT(25, 30, "Overweight"),
    OBESE(30, Double.MAX_VALUE, "Obese");

    private final double minValue;
    private final double maxValue;
    private final String description;

    BmiCategory(double minValue, double maxValue, String description) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.description = description;
    }

    public static BmiCategory fromBmi(double bmi) {
        for (BmiCategory category : BmiCategory.values()) {
            if (bmi >= category.minValue && bmi < category.maxValue) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid BMI value: " + bmi);
    }

    public String getDescription() {
        return description;
    }
}
