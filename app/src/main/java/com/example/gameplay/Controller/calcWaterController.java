package com.example.gameplay.Controller;

import com.example.gameplay.Model.calcWaterModel;

public class calcWaterController {
    private final calcWaterModel model;

    public calcWaterController() {
        model = new calcWaterModel();
    }

    public String calculateWaterNeed(float weight) {
        double water = model.calculateDailyWaterNeed(weight);
        return String.format("%.3f", water); // Format result to 3 decimal places
    }

    public String getErrorMessage() {
        return "Weight Missing!";
    }

    public String getResultMessage(String waterString) {
        return "You Need " + waterString + "L Water Daily.";
    }
}
