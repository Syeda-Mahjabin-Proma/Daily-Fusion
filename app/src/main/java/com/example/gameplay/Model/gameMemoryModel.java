package com.example.gameplay.Model;

import java.util.ArrayList;
import java.util.Random;

public class gameMemoryModel {
    private ArrayList<Integer> values;
    private int score;
    private int lives;

    public gameMemoryModel() {
        values = new ArrayList<>();
        score = 0;
        lives = 3;
    }

    public void generateRandomValues() {
        values.clear();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            values.add(random.nextInt(100)); // Random numbers between 0-99
        }
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public void incrementScore() {
        score++;
    }

    public void decrementLives() {
        lives--;
    }
}
