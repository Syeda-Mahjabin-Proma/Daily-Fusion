package com.example.gameplay.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.gameRightWrongController;
import com.example.gameplay.R;

public class gameRightWrongView extends AppCompatActivity {
    private gameRightWrongController controller;

    private TextView val1, val2, val3, resultText, scoreVal, lifeVal;
    private Button yesButton, noButton;
    private LinearLayout resultLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_right_wrong_number);

        controller = new gameRightWrongController();
        findViews();
        updateUI();

        yesButton.setOnClickListener(v -> handleAnswer(true));
        noButton.setOnClickListener(v -> handleAnswer(false));
    }

    private void findViews() {
        val1 = findViewById(R.id.val_1);
        val2 = findViewById(R.id.val_2);
        val3 = findViewById(R.id.val_3);
        resultText = findViewById(R.id.result_text);
        scoreVal = findViewById(R.id.score_val);
        lifeVal = findViewById(R.id.life_val);
        yesButton = findViewById(R.id.button_yes);
        noButton = findViewById(R.id.button_no);
        resultLayout = findViewById(R.id.all_result);
    }

    private void updateUI() {
        val1.setText(String.valueOf(controller.getFirstVal()));
        val2.setText(String.valueOf(controller.getSecondVal()));
        val3.setText(String.valueOf(controller.getThirdVal()));
        scoreVal.setText(String.valueOf(controller.getScore()));
        lifeVal.setText(String.valueOf(controller.getLife()));
    }

    private void handleAnswer(boolean userAnswer) {
        boolean isCorrect = controller.checkUserAnswer(userAnswer);
        if (isCorrect) {
            Toast.makeText(this, "Right Answer", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

        if (controller.isGameOver()) {
            displayGameOver();
        } else {
            controller.generateNewValues();
            updateUI();
        }
    }

    private void displayGameOver() {
        resultText.setText("Game Over\nYour Score: " + controller.getScore());
        lifeVal.setText("0");
        yesButton.setEnabled(false);
        noButton.setEnabled(false);
        Button restartButton = new Button(this);
        restartButton.setText("Start Again");
        resultLayout.addView(restartButton);
        restartButton.setOnClickListener(v -> recreate());
        Button exitButton = new Button(this);
        exitButton.setText("Exit");
        resultLayout.addView(exitButton);
        exitButton.setOnClickListener(v -> finish());
    }
}
