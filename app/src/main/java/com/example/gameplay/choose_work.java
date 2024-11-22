package com.example.gameplay;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choose_work extends AppCompatActivity {
    private Button playGame, weightCheck, todo, motivation, moneyCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_work);
        findViews();
        onClick();
    }

    private void findViews() {
        playGame = findViewById(R.id.playGame);
        weightCheck = findViewById(R.id.weightCheck);
        todo = findViewById(R.id.todo);
        motivation = findViewById(R.id.motivation);
        moneyCalculate = findViewById(R.id.moneyCalculate);
    }

    private void onClick() {
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose_work.this, gameplay.class));
            }
        });

        weightCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose_work.this, health_check.class));
            }
        });
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose_work.this, workList.class));

            }
        });
        motivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose_work.this, motivate.class));
            }
        });
        moneyCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose_work.this, calcMoney.class));
            }
        });
    }
}