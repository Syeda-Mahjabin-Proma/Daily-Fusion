package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.calcWaterController;
import com.example.gameplay.R;

public class calcWaterView extends AppCompatActivity {
    private EditText weightInput;
    private Button calculateButton;
    private TextView resultText;
    private calcWaterController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_water_level);

        controller = new calcWaterController(); // Initialize the controller
        findViews();
        setCalculateButtonListener();
    }

    private void findViews() {
        weightInput = findViewById(R.id.weight);
        calculateButton = findViewById(R.id.calculate);
        resultText = findViewById(R.id.result);
    }

    private void setCalculateButtonListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightText = weightInput.getText().toString();
                if (weightText.isEmpty()) {
                    resultText.setText(controller.getErrorMessage());
                } else {
                    float weight = Float.parseFloat(weightText);
                    String waterString = controller.calculateWaterNeed(weight);
                    resultText.setText(controller.getResultMessage(waterString));
                }
            }
        });
    }
}
