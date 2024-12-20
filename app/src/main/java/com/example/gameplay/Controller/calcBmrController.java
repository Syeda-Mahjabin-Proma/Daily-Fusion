package com.example.gameplay.Controller;

import com.example.gameplay.Model.calcBmrModel;

public class calcBmrController {
    private final calcBmrModel model;

    public calcBmrController() {
        this.model = new calcBmrModel();
    }

    public String calculateBMR(int feet, float inch, float weight, int age, boolean isMale) {
        double[] bmrHeight = model.calculateBmr(feet, inch, weight, age, isMale);
        double bmr = bmrHeight[0];
        double height = bmrHeight[1];

        if (bmr == 0) {
            return "Please Fill-up Height & Weight Properly";
        } else {
            return "You Need " + String.format("%.1f", bmr) + " Calories Daily";
        }
    }

    public String validateAge(int age) {
        if (age >= 18) {
            return "Proceed with calculation";
        } else {
            return "As You are Under 18, Consult With Your Doctor";
        }
    }
}
