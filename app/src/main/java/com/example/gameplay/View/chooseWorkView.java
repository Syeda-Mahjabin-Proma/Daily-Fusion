package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.chooseWorkController;
import com.example.gameplay.R;

public class chooseWorkView extends AppCompatActivity {
    private Button playGame, weightCheck, todo, motivation, moneyCalculate;
    private chooseWorkController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_work);

        findViews();
        controller = new chooseWorkController(this);
        setUpButtonOnClickListener();
    }

    private void findViews() {
        playGame = findViewById(R.id.playGame);
        weightCheck = findViewById(R.id.weightCheck);
        todo = findViewById(R.id.todo);
        motivation = findViewById(R.id.motivation);
        moneyCalculate = findViewById(R.id.moneyCalculate);
    }

    private void setUpButtonOnClickListener() {
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handlePlayGame();
            }
        });

        weightCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleWeightCheck();
            }
        });

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleWorkList();
            }
        });

        motivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleMotivation();
            }
        });

        moneyCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleMoneyCalculate();
            }
        });
    }
}
