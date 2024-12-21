package com.example.gameplay.Controller;

import android.widget.RadioButton;
import android.widget.Toast;

import com.example.gameplay.Model.gameRockPaperScissorModel;
import com.example.gameplay.View.gameRockPaperScissorView;

public class gameRockPaperScissorController {
    private final gameRockPaperScissorModel model;
    private final gameRockPaperScissorView view;

    public gameRockPaperScissorController(gameRockPaperScissorModel model, gameRockPaperScissorView view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        if (view.getSelectedRadioButtonId() == -1) {
            Toast.makeText(view, "Select One!", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedOption = view.findViewById(view.getSelectedRadioButtonId());
        String playerChoice = selectedOption.getText().toString();
        String computerChoice = model.getComputerChoice();

        view.updateChoices(playerChoice, computerChoice);
        String winner = model.determineWinner(playerChoice, computerChoice);
        view.showWinner(winner);
        view.updateScores(model.getPlayerScore(), model.getComputerScore());

    }

    public int getPlayerScore() {
        return model.getPlayerScore();
    }

    public int getComputerScore() {
        return model.getComputerScore();
    }
}
