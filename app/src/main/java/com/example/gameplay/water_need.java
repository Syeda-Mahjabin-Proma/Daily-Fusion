package com.example.gameplay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class water_need extends AppCompatActivity {
    private EditText weight;
    private Button calculate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_need);
        findViews();
        setUpButtonOnClickListener();
    }

    private void findViews() {
        weight = findViewById(R.id.weight);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
    }

    private void setUpButtonOnClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String weightText = weight.getText().toString();
                if (weightText.isEmpty()){
                    result.setText("Weight Missing!");
                } else {
                    int weight = Integer.parseInt(weightText);
                    double water = weight * 0.033;
                    String waterString = String.format("%.3f", water);
                    result.setText("You Need " + waterString + "L Water Daily.");
                }
            }
        });
    }


}