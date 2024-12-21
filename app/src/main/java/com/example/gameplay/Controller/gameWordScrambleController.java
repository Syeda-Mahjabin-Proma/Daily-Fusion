package com.example.gameplay.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameplay.Model.gameWordScrambleModel;

public class gameWordScrambleController {
    private final gameWordScrambleModel model;
    private final TextView givenWord;
    private final TextView score_val;
    private final TextView life_val;
    private final TextView finalResultTextView;
    private final TextView welcome;
    private final TextView wordgen;
    private final TextView playerGuess;
    private final EditText playerWord;
    private final Button checkButton;
    private final Button playAgain;
    private final Button exit;
    private final View newButton;
    private final View scoreLife;

    public gameWordScrambleController(gameWordScrambleModel model, TextView givenWord, TextView score_val, TextView life_val,
                                      TextView finalResultTextView, TextView welcome, TextView wordgen, TextView playerGuess,
                                      EditText playerWord, Button checkButton, Button playAgain, Button exit,
                                      View newButton, View scoreLife) {
        this.model = model;
        this.givenWord = givenWord;
        this.score_val = score_val;
        this.life_val = life_val;
        this.finalResultTextView = finalResultTextView;
        this.welcome = welcome;
        this.wordgen = wordgen;
        this.playerGuess = playerGuess;
        this.playerWord = playerWord;
        this.checkButton = checkButton;
        this.playAgain = playAgain;
        this.exit = exit;
        this.newButton = newButton;
        this.scoreLife = scoreLife;
    }

    public void startGame() {
        updateUI();
        setupListeners();
    }

    private void setupListeners() {
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPlayerGuess();
            }
        });

    }

    private void checkPlayerGuess() {
        String playerGuessText = playerWord.getText().toString().trim();
        if (playerGuessText.isEmpty()) {
            Toast.makeText(playerWord.getContext(), "Please enter a guess!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isCorrect = model.checkPlayerGuess(playerGuessText);

        if (isCorrect) {
            score_val.setText(String.valueOf(model.getScore()));
            Toast.makeText(playerWord.getContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            life_val.setText(String.valueOf(model.getLives()));
            Toast.makeText(playerWord.getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
        }

        if (model.getLives() == 0) {
            endGame();
        } else {
            updateUI();
        }
    }

    private void endGame() {
        welcome.setText("Game Over!!!");
        finalResultTextView.setVisibility(View.VISIBLE);
        finalResultTextView.setText("Your Score: " + model.getScore());
        wordgen.setText("The Word Was: ");
        givenWord.setText(model.getCurrentWord());
        playerGuess.setVisibility(View.GONE);
        playerWord.setVisibility(View.GONE);
        checkButton.setVisibility(View.GONE);
        scoreLife.setVisibility(View.GONE);
        newButton.setVisibility(View.VISIBLE);
    }

    private void updateUI() {
        givenWord.setText(model.getShuffledWord());
        score_val.setText(String.valueOf(model.getScore()));
        life_val.setText(String.valueOf(model.getLives()));
        playerWord.setText("");
    }

}
