package com.example.gameplay.View;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.gameTicTacToeController;
import com.example.gameplay.Model.gameTicTacToeModel;
import com.example.gameplay.R;

public class gameTicTacToeView extends AppCompatActivity {
    private gameTicTacToeController controller;
    private TextView[] boxes;
    private TextView player1ScoreTextView, player2ScoreTextView;
    private Button playAgain, exit, reset;
    private boolean gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_tic_tac_toe);
        findViews();
        allButton();

        gameTicTacToeModel model = new gameTicTacToeModel();
        controller = new gameTicTacToeController(model, this);

        for (int i = 0; i < 9; i++) {
            final int index = i;
            boxes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    controller.onBoxClick(index);
                }
            });
        }
    }

    private void allButton() {
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.resetGame();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void findViews() {
        boxes = new TextView[9];
        boxes[0] = findViewById(R.id.box1);
        boxes[1] = findViewById(R.id.box2);
        boxes[2] = findViewById(R.id.box3);
        boxes[3] = findViewById(R.id.box4);
        boxes[4] = findViewById(R.id.box5);
        boxes[5] = findViewById(R.id.box6);
        boxes[6] = findViewById(R.id.box7);
        boxes[7] = findViewById(R.id.box8);
        boxes[8] = findViewById(R.id.box9);
        player1ScoreTextView = findViewById(R.id.player1_score);
        player2ScoreTextView = findViewById(R.id.player2_score);
        playAgain = findViewById(R.id.play_again);
        exit = findViewById(R.id.end_game);
        reset = findViewById(R.id.start_over);
    }

    public void updateBox(int index, String symbol) {
        boxes[index].setText(symbol);
        boxes[index].setTextColor(Color.BLACK);
    }

    public void displayWinner(String winner) {
        gameOver = true;
        String winnerText = "Player " + (winner.equals("X") ? "1" : "2") + " wins!";
        Toast.makeText(this, winnerText, Toast.LENGTH_SHORT).show();
    }

    public void highlightWinningCells(String symbol) {
        for (int i = 0; i < 9; i++) {
            if (boxes[i].getText().toString().equals(symbol)) {
                boxes[i].setTextColor(Color.RED);
            }
        }
    }

    public void updateScores(int player1Score, int player2Score) {
        player1ScoreTextView.setText(String.valueOf(player1Score));
        player2ScoreTextView.setText(String.valueOf(player2Score));
    }

    public void resetGameUI() {
        for (int i = 0; i < 9; i++) {
            boxes[i].setText("");
            boxes[i].setTextColor(Color.BLACK);
        }
        gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
