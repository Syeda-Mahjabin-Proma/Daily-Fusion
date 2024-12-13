package com.example.gameplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class calories_burn extends AppCompatActivity {
    private EditText met, weight,duration ;
    private Button calculate;
    private TextView reset_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calory_burn);
        findViews();
        setUpButtonOnClickListener();
    }

    private void findViews() {
        met = findViewById(R.id.met);
        weight = findViewById(R.id.weight);
        duration = findViewById(R.id.duration);
        calculate = findViewById(R.id.calculate);
        reset_text = findViewById(R.id.reset_text);
    }

    private void setUpButtonOnClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String metText = met.getText().toString();
                String weightText = weight.getText().toString();
                String durationText = duration.getText().toString();
                if (metText.isEmpty() || weightText.isEmpty() || durationText.isEmpty()){
                    reset_text.setText("Enter Values Properly");
                }
                else {
                    int weight = Integer.parseInt(weightText);
                    int met = Integer.parseInt(metText);
                    int duration = Integer.parseInt(durationText);
                    double cal_burn = weight * met * duration;
                    String calString = String.format("%.2f", cal_burn);
                    reset_text.setText("You Burnt " + calString + " Calories Today");
                    Toast.makeText(calories_burn.this, "Calculation Done!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}