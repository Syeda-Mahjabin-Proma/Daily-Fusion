package com.example.gameplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class calcBSA extends AppCompatActivity {
    private EditText height_feet, height_inch, weight;
    private Button calculate;
    private TextView reset_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_bsa);
        findViews();
        setUpButtonOnClickListener();
    }

    private void findViews() {
        height_feet = findViewById(R.id.height_feet);
        height_inch = findViewById(R.id.height_inch);
        weight = findViewById(R.id.weight);
        calculate = findViewById(R.id.calculate);
        reset_text = findViewById(R.id.reset_text);
    }

    private void setUpButtonOnClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feetText = height_feet.getText().toString();
                String inchText = height_inch.getText().toString();
                String weightText = weight.getText().toString();
                if (feetText.isEmpty() || inchText.isEmpty() || weightText.isEmpty()){
                    reset_text.setText("Enter Height & Weight Properly");
                }
                else {
                    int feet = Integer.parseInt(feetText);
                    int inch = Integer.parseInt(inchText);
                    int weight = Integer.parseInt(weightText);
                    double total_height = ((feet * 12) + inch) * 2.54;
                    double bsa = Math.sqrt((weight * total_height)/3600);
                    String bsaString = String.format("%.2f", bsa);
                    reset_text.setText("Your Body Surface Area is: " + bsaString + " Square Meters.");
                    Toast.makeText(calcBSA.this, "Your BSA Calculation is Done!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}