package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.calcBmiController;
import com.example.gameplay.R;

public class calcBmiView extends AppCompatActivity {

    private RadioButton radioButtonMale, radioButtonFemale;
    private EditText age, heightFeet, heightInch, weight;
    private Button calculateButton;
    private TextView resultText;
    private calcBmiController bmiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_bmi);
        findViews();
        bmiController = new calcBmiController();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiController.calculateBMI(radioButtonMale, radioButtonFemale, age, heightFeet, heightInch, weight, resultText);
            }
        });
    }

    private void findViews() {
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.age);
        heightFeet = findViewById(R.id.height_feet);
        heightInch = findViewById(R.id.height_inch);
        weight = findViewById(R.id.weight);
        calculateButton = findViewById(R.id.calculate);
        resultText = findViewById(R.id.reset_text);
    }
}
