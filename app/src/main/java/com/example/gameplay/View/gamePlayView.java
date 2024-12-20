package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.gamePlayController;
import com.example.gameplay.R;

public class gamePlayView extends AppCompatActivity {
    private Button numberChoose, tictactoe, memory, word, rockPaperScissor;

    private gamePlayController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);

        findViews();
        controller = new gamePlayController(this);
        onClick();
    }

    private void findViews() {
        numberChoose = findViewById(R.id.numberChoose);
        tictactoe = findViewById(R.id.tictactoe);
        memory = findViewById(R.id.memory);
        word = findViewById(R.id.word);
        rockPaperScissor = findViewById(R.id.rockPaperScissor);
    }

    private void onClick() {
        numberChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleRightWrong();
            }
        });

        tictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleTicTacToe();
            }
        });

        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleMemoryGame();
            }
        });

        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleWordGame();
            }
        });

        rockPaperScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.handleRockPaperScissor();
            }
        });
    }
}
