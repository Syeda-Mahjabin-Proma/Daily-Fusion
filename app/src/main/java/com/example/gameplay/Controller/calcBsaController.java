package com.example.gameplay.Controller;

import android.widget.TextView;

import com.example.gameplay.Model.calcBsaModel;

public class calcBsaController {
    private final calcBsaModel model;

    public calcBsaController() {
        model = new calcBsaModel();
    }

    public String calculateBsa(int feet, float inches, float weight) {
        double bsa = model.calculateBsa(feet, inches, weight);
        return String.format("%.2f", bsa);
    }

    public void setErrorMessage(TextView resultText) {
        resultText.setText("Enter Height & Weight Properly");
    }

    public void setSuccessMessage(TextView resultText, String bsaValue) {
        resultText.setText("Your Body Surface Area is: " + bsaValue + " Square Meters.");
    }
}
