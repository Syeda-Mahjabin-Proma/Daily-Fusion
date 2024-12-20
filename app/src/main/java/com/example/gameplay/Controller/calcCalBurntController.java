package com.example.gameplay.Controller;

import com.example.gameplay.Model.calcCalBurntModel;

public class calcCalBurntController {
    private final calcCalBurntModel model;

    public calcCalBurntController() {
        model = new calcCalBurntModel();
    }

    public double calculateCaloriesBurned(float weight, int met, float duration) {
        return model.calculateCalories(weight, met, duration);
    }

    public String formatCalories(double calories) {
        return String.format("%.2f", calories);
    }

    public String getErrorMessage() {
        return "Enter Values Properly";
    }

    public String getResultMessage(String calories) {
        return "You Burnt " + calories + " Calories Today";
    }
}
