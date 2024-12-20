package com.example.gameplay.Controller;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.gameplay.Model.calcBmiModel;

public class calcBmiController {

    private final calcBmiModel bmiModel;

    public calcBmiController() {
        this.bmiModel = new calcBmiModel();
    }

    public void calculateBMI(RadioButton radioButtonMale, RadioButton radioButtonFemale, EditText ageField, EditText heightFeetField, EditText heightInchField, EditText weightField, TextView resultText) {
        if (radioButtonMale.isChecked() || radioButtonFemale.isChecked()) {
            String ageText = ageField.getText().toString();
            String feetText = heightFeetField.getText().toString();
            String inchText = heightInchField.getText().toString();
            String weightText = weightField.getText().toString();

            if (ageText.isEmpty() || feetText.isEmpty() || inchText.isEmpty() || weightText.isEmpty()) {
                resultText.setText("Please fill all fields properly.");
                return;
            }

            int age = Integer.parseInt(ageText);
            int feet = Integer.parseInt(feetText);
            float inch = Float.parseFloat(inchText);
            float weight = Float.parseFloat(weightText);

            double[] bmiHeight = bmiModel.calculateBmi(feet, inch, weight);

            if (age >= 18) {
                String outcome = bmiModel.calculateBMIOutcome(bmiHeight[0], bmiHeight[1]);
                resultText.setText(outcome);
            } else {
                resultText.setText("As You are Under 18, Consult With Your Doctor.");
            }
        } else {
            resultText.setText("Select Gender");
        }
    }
}

