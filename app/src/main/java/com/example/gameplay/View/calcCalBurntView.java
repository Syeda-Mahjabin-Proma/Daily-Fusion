package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.calcCalBurntController;
import com.example.gameplay.R;

public class calcCalBurntView extends AppCompatActivity {
    private EditText metInput, weightInput, durationInput;
    private Button calculateButton;
    private TextView resultText;
    private calcCalBurntController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_cal_burn);
        controller = new calcCalBurntController(); // Initialize the controller
        findViews();
        setCalculateButtonListener();
    }

    private void findViews() {
        metInput = findViewById(R.id.met);
        weightInput = findViewById(R.id.weight);
        durationInput = findViewById(R.id.duration);
        calculateButton = findViewById(R.id.calculate);
        resultText = findViewById(R.id.reset_text);
    }

    private void setCalculateButtonListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String metText = metInput.getText().toString();
                String weightText = weightInput.getText().toString();
                String durationText = durationInput.getText().toString();

                if (metText.isEmpty() || weightText.isEmpty() || durationText.isEmpty()) {
                    resultText.setText(controller.getErrorMessage());
                } else {
                    float weight = Float.parseFloat(weightText);
                    int met = Integer.parseInt(metText);
                    float duration = Float.parseFloat(durationText);

                    double caloriesBurned = controller.calculateCaloriesBurned(weight, met, duration);
                    String caloriesString = controller.formatCalories(caloriesBurned);

                    resultText.setText(controller.getResultMessage(caloriesString));
                    Toast.makeText(calcCalBurntView.this, "Calculation Done!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
