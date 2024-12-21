package com.example.gameplay.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.gameMemoryController;
import com.example.gameplay.Model.gameMemoryModel;
import com.example.gameplay.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class gameMemoryView extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private TextView val1, val2, val3, val4, val5, scoreVal, lifeVal, resultText, careful, scoreText, lifeText, divider;
    private Button b1, b2, b3;
    private LinearLayout allResult;
    private gameMemoryController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_memory_game);

        gameMemoryModel model = new gameMemoryModel();
        controller = new gameMemoryController(model);

        findViews();
        startGame();
    }

    private void findViews() {
        val1 = findViewById(R.id.val_1);
        val2 = findViewById(R.id.val_2);
        val3 = findViewById(R.id.val_3);
        val4 = findViewById(R.id.val_4);
        val5 = findViewById(R.id.val_5);
        scoreVal = findViewById(R.id.score_val);
        lifeVal = findViewById(R.id.life_val);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        resultText = findViewById(R.id.final_result);
        careful = findViewById(R.id.careful);
        scoreText = findViewById(R.id.score_text);
        lifeText = findViewById(R.id.life_text);
        divider = findViewById(R.id.divider);
        allResult = findViewById(R.id.all_result);
    }

    private void startGame() {
        controller.generateRandomValues();
        displayValues();
        hideButtons();
        setButtonsEnabled(false);

        handler.postDelayed(() -> {
            hideValues();
            setButtonOptions();
            setButtonsEnabled(true);
        }, 3000);

        setupButtonListeners();
    }

    private void hideButtons() {
        b1.setText(" X ");
        b3.setText(" Y ");
        b2.setText(" Z ");
    }

    private void displayValues() {
        val1.setText(controller.getValueAtIndex(0));
        val2.setText(controller.getValueAtIndex(1));
        val3.setText(controller.getValueAtIndex(2));
        val4.setText(controller.getValueAtIndex(3));
        val5.setText(controller.getValueAtIndex(4));
    }

    private void hideValues() {
        val1.setText(" A ");
        val2.setText(" B ");
        val3.setText(" C ");
        val4.setText(" D ");
        val5.setText(" E ");
    }

    private void setButtonOptions() {
        Random random = new Random();
        ArrayList<Integer> buttonOptions = new ArrayList<>(controller.getValues());

        while (buttonOptions.size() < 8) {
            int randomValue = random.nextInt(100);
            if (!controller.getValues().contains(randomValue)) {
                buttonOptions.add(randomValue);
            }
        }

        Collections.shuffle(buttonOptions);
        b1.setText(String.valueOf(buttonOptions.get(0)));
        b2.setText(String.valueOf(buttonOptions.get(1)));
        b3.setText(String.valueOf(buttonOptions.get(2)));
    }

    private void setupButtonListeners() {
        View.OnClickListener buttonListener = view -> {
            Button clickedButton = (Button) view;
            int selectedValue = Integer.parseInt(clickedButton.getText().toString());

            if (controller.checkValue(selectedValue)) {
                scoreVal.setText(String.valueOf(controller.getScore()));
            } else {
                lifeVal.setText(String.valueOf(controller.getLives()));
            }

            if (controller.isGameOver()) {
                endGame();
            } else {
                startGame();
            }
        };

        b1.setOnClickListener(buttonListener);
        b2.setOnClickListener(buttonListener);
        b3.setOnClickListener(buttonListener);
    }

    private void setButtonsEnabled(boolean enabled) {
        b1.setEnabled(enabled);
        b2.setEnabled(enabled);
        b3.setEnabled(enabled);
    }

    private void endGame() {
        careful.setVisibility(View.GONE);
        val1.setVisibility(View.GONE);
        val2.setVisibility(View.GONE);
        val3.setVisibility(View.GONE);
        val4.setVisibility(View.GONE);
        val5.setVisibility(View.GONE);
        resultText.setText("Game Over\nYour Score is: " + controller.getScore());
        scoreText.setVisibility(View.GONE);
        scoreVal.setVisibility(View.GONE);
        divider.setVisibility(View.GONE);
        lifeText.setVisibility(View.GONE);
        lifeVal.setVisibility(View.GONE);
        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);

        Button newStartButton = new Button(this);
        newStartButton.setText("Play Again");
        allResult.addView(newStartButton);

        Button newStopButton = new Button(this);
        newStopButton.setText("Exit");
        allResult.addView(newStopButton);

        newStartButton.setOnClickListener(v -> {
            finish();
            startActivity(getIntent());
        });

        newStopButton.setOnClickListener(v -> finish());
    }
}
