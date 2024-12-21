package com.example.gameplay.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.gameplay.Controller.gameRockPaperScissorController;
import com.example.gameplay.Model.gameRockPaperScissorModel;
import com.example.gameplay.R;

public class gameRockPaperScissorView extends Activity {

    private RadioGroup radioGroup;
    private Button submit, endGame, replay, exit;
    private LinearLayout newBtn, computerSelection, playerSelection;
    private TextView playerScore, computerScore, winnerSelection, playerSelect, computerSelect,
            welcome, selectOne, winnerText;

    private gameRockPaperScissorController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_rock_paper_scissor);
        findViews();
        gameRockPaperScissorModel model = new gameRockPaperScissorModel();
        controller = new gameRockPaperScissorController(model, this);
        submitgame();
        endGamePlay();
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void endGamePlay() {
        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome.setVisibility(View.GONE);
                selectOne.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                computerSelection.setVisibility(View.GONE);
                playerSelection.setVisibility(View.GONE);
                winnerText.setText("Winner: ");
                int playerScore = controller.getPlayerScore();
                int computerSCore = controller.getComputerScore();
                if (playerScore > computerSCore) {
                    winnerSelection.setText(" YOU ");
                } else if (playerScore < computerSCore) {
                    winnerSelection.setText(" COMPUTER ");
                } else {
                    winnerSelection.setText(" DRAW ");
                }
                endGame.setVisibility(View.GONE);
                newBtn.setVisibility(View.VISIBLE);
                replay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        startActivity(getIntent());
                    }
                });

                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

            }
        });
    }

    private void submitgame() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.playGame();
                radioGroup.clearCheck();
            }
        });
    }

    private void findViews() {
        radioGroup = findViewById(R.id.radioGroup);
        submit = findViewById(R.id.submit);
        endGame = findViewById(R.id.endGame);
        exit = findViewById(R.id.exit);
        replay = findViewById(R.id.rePlay);
        playerScore = findViewById(R.id.playerScore);
        computerScore = findViewById(R.id.computerScore);
        winnerSelection = findViewById(R.id.winnerSelection);
        playerSelect = findViewById(R.id.playerSelect);
        computerSelect = findViewById(R.id.computerSelect);
        newBtn = findViewById(R.id.newBtn);
        playerSelection = findViewById(R.id.playerSelectionLayout);
        computerSelection = findViewById(R.id.computerSelectionLayout);
        welcome = findViewById(R.id.welcome);
        selectOne = findViewById(R.id.selectOne);
        winnerText = findViewById(R.id.winnerText);
    }

    public int getSelectedRadioButtonId() {
        return radioGroup.getCheckedRadioButtonId();
    }

    public void updateScores(int player, int computer) {
        playerScore.setText(String.format("%02d", player));
        computerScore.setText(String.format("%02d", computer));
    }

    public void updateChoices(String playerChoice, String computerChoice) {
        playerSelect.setText(playerChoice);
        computerSelect.setText(computerChoice);
    }

    public void showWinner(String winner) {
        winnerSelection.setText(winner);
    }


}
