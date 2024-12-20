package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.calcBsaController;
import com.example.gameplay.R;

public class calcBsaView extends AppCompatActivity {
    private EditText heightFeetInput, heightInchInput, weightInput;
    private Button calculateButton;
    private TextView resultText;
    private calcBsaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_bsa);

        controller = new calcBsaController();
        findViews();
        setCalculateButtonListener();
    }

    private void setCalculateButtonListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feetText = heightFeetInput.getText().toString();
                String inchText = heightInchInput.getText().toString();
                String weightText = weightInput.getText().toString();

                if (feetText.isEmpty() || inchText.isEmpty() || weightText.isEmpty()) {
                    controller.setErrorMessage(resultText);
                } else {
                    int feet = Integer.parseInt(feetText);
                    float inches = Float.parseFloat(inchText);
                    float weight = Float.parseFloat(weightText);

                    String bsaValue = controller.calculateBsa(feet, inches, weight);
                    controller.setSuccessMessage(resultText, bsaValue);

                    Toast.makeText(calcBsaView.this, "Your BSA Calculation is Done!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findViews() {
        heightFeetInput = findViewById(R.id.height_feet);
        heightInchInput = findViewById(R.id.height_inch);
        weightInput = findViewById(R.id.weight);
        calculateButton = findViewById(R.id.calculate);
        resultText = findViewById(R.id.reset_text);
    }
}
