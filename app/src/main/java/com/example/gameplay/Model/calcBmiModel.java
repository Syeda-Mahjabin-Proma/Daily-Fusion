package com.example.gameplay.Model;

public class calcBmiModel {

    public double[] calculateBmi(int feet, float inch, float weight) {
        double[] bmi_height;
        if (feet <= 0 || inch <= 0 || weight <= 0) {
            bmi_height = new double[]{0, 0};
        } else {
            double totalHeight = ((feet * 12) + inch) * 0.0254;
            double bmi = weight / (totalHeight * totalHeight);
            bmi_height = new double[]{bmi, totalHeight};
        }
        return bmi_height;
    }

    public String calculateBMIOutcome(double bmi, double height) {
        double minWeight = 18.5 * (height * height);
        double maxWeight = 24.9 * (height * height);
        String preference = "Your Healthy Weight Range is from " + String.format("%.0f", minWeight) + " kg to " + String.format("%.0f", maxWeight) + " kg. ";
        String bmiString = String.format("%.1f", bmi);
        String finalOutcome;

        if (bmi == 0) {
            finalOutcome = "Please Fill-up Height & Weight Properly";
        } else if (bmi < 18.5) {
            finalOutcome = "Your BMI is: " + bmiString + " and You are UNDERWEIGHT. ";
        } else if (bmi < 25.0) {
            finalOutcome = "Your BMI is: " + bmiString + " and You are HEALTHY. ";
        } else if (bmi < 30.0) {
            finalOutcome = "Your BMI is: " + bmiString + " and You are OVERWEIGHT. ";
        } else {
            finalOutcome = "Your BMI is: " + bmiString + " and You are OBESE. ";
        }
        return finalOutcome + "\n" + preference;
    }
}
