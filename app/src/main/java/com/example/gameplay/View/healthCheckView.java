package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.healthCheckController;
import com.example.gameplay.R;

public class healthCheckView extends AppCompatActivity {
    private Button bmi, bmr, water, bsi, calories;
    private healthCheckController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_check);

        findViews();
        controller = new healthCheckController(this);
        setUpButtonOnClickListener();
    }

    private void findViews() {
        bmi = findViewById(R.id.bmi);
        bmr = findViewById(R.id.bmr);
        water = findViewById(R.id.water);
        bsi = findViewById(R.id.bsi);
        calories = findViewById(R.id.calories);
    }

    private void setUpButtonOnClickListener() {
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleBmiCheck();
            }
        });

        bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleBmrCheck();
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleWaterIntakeCheck();
            }
        });

        bsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleBsaCheck();
            }
        });

        calories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleCaloriesBurnedCheck();
            }
        });
    }
}
