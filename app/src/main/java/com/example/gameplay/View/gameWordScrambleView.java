package com.example.gameplay.View;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.gameWordScrambleController;
import com.example.gameplay.Model.gameWordScrambleModel;
import com.example.gameplay.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class gameWordScrambleView extends AppCompatActivity {

    private gameWordScrambleController controller;
    private gameWordScrambleModel model;
    private TextView givenWord, score_val, life_val, finalResultTextView, welcome, wordgen, playerGuess;
    private EditText playerWord;
    private Button checkButton, playAgain, exit;
    private LinearLayout newButton, scoreLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_word_scramble);
        findViews();
        ArrayList<String> words = loadWordsFromAssets();
        model = new gameWordScrambleModel(words);
        controller = new gameWordScrambleController(model, givenWord, score_val, life_val, finalResultTextView,
                welcome, wordgen, playerGuess, playerWord, checkButton, playAgain,
                exit, newButton, scoreLife);

        controller.startGame();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void findViews() {
        givenWord = findViewById(R.id.givenWord);
        score_val = findViewById(R.id.score_val);
        life_val = findViewById(R.id.life_val);
        finalResultTextView = findViewById(R.id.finalResult);
        welcome = findViewById(R.id.welcome);
        wordgen = findViewById(R.id.wordGenerate);
        playerGuess = findViewById(R.id.playerGuess);
        playerWord = findViewById(R.id.playerWord);
        checkButton = findViewById(R.id.check);
        playAgain = findViewById(R.id.playAgain);
        exit = findViewById(R.id.exit);
        newButton = findViewById(R.id.newBtn);
        scoreLife = findViewById(R.id.scoreLife);
    }

    private ArrayList<String> loadWordsFromAssets() {
        ArrayList<String> words = new ArrayList<>();
        AssetManager assetManager = getAssets();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open("words.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading words.", Toast.LENGTH_SHORT).show();
        }
        return words;
    }

}
