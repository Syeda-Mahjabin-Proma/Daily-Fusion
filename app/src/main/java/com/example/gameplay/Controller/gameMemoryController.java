package com.example.gameplay.Controller;

import com.example.gameplay.Model.gameMemoryModel;

import java.util.ArrayList;

public class gameMemoryController {
    private final gameMemoryModel model;

    public gameMemoryController (gameMemoryModel model) {
        this.model = model;
    }

    public void generateRandomValues() {
        model.generateRandomValues();
    }

    public String getValueAtIndex(int index) {
        return String.valueOf(model.getValues().get(index));
    }

    public ArrayList<Integer> getValues() {
        return model.getValues();
    }

    public boolean checkValue(int selectedValue) {
        boolean isCorrect = model.getValues().contains(selectedValue);
        if (isCorrect) {
            model.incrementScore();
        } else {
            model.decrementLives();
        }
        return isCorrect;
    }

    public int getScore() {
        return model.getScore();
    }

    public int getLives() {
        return model.getLives();
    }

    public boolean isGameOver() {
        return model.getLives() <= 0;
    }
}
