package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.calcBmrController;
import com.example.gameplay.R;

public class calcBmrView extends AppCompatActivity {
    private RadioButton radio_button_male, radio_button_female;
    private EditText age, height_feet, height_inch, weight;
    private Button calculate;
    private TextView reset_text;
    private calcBmrController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_bmr);

        findViews();
        controller = new calcBmrController();
        setUpButtonOnClickListener();
    }

    private void setUpButtonOnClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ageText = age.getText().toString();
                if (ageText.isEmpty()) {
                    reset_text.setText("Enter Age");
                } else {
                    int ageValue = Integer.parseInt(ageText);
                    String ageValidationResult = controller.validateAge(ageValue);
                    reset_text.setText(ageValidationResult);

                    if (ageValue >= 18) {
                        if (radio_button_male.isChecked() || radio_button_female.isChecked()) {
                            boolean isMale = radio_button_male.isChecked();
                            String feetText = height_feet.getText().toString();
                            String inchText = height_inch.getText().toString();
                            String weightText = weight.getText().toString();

                            if (feetText.isEmpty() || inchText.isEmpty() || weightText.isEmpty()) {
                                reset_text.setText("Please Fill-up Height & Weight Properly");
                            } else {
                                int feet = Integer.parseInt(feetText);
                                float inch = Float.parseFloat(inchText);
                                float weightValue = Float.parseFloat(weightText);

                                String result = controller.calculateBMR(feet, inch, weightValue, ageValue, isMale);
                                reset_text.setText(result);
                                Toast.makeText(calcBmrView.this, "Your BMR Calculation is Done!!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            reset_text.setText("Select Gender");
                        }
                    }
                }
            }
        });
    }

    private void findViews() {
        radio_button_male = findViewById(R.id.radio_button_male);
        radio_button_female = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.age);
        height_feet = findViewById(R.id.height_feet);
        height_inch = findViewById(R.id.height_inch);
        weight = findViewById(R.id.weight);
        calculate = findViewById(R.id.calculate);
        reset_text = findViewById(R.id.reset_text);
    }
}
