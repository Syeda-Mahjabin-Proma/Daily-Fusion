package com.example.gameplay.Controller;

import com.example.gameplay.Model.gameRightWrongModel;

public class gameRightWrongController {
    private final gameRightWrongModel model;

    public gameRightWrongController() {
        model = new gameRightWrongModel();
    }

    public void generateNewValues() {
        model.generateValues();
    }

    public int getFirstVal() {
        return model.getFirstVal();
    }

    public int getSecondVal() {
        return model.getSecondVal();
    }

    public int getThirdVal() {
        return model.getThirdVal();
    }

    public int getLife() {
        return model.getLife();
    }

    public int getScore() {
        return model.getScore();
    }

    public boolean checkUserAnswer(boolean userAnswer) {
        return model.isAnswerCorrect(userAnswer);
    }

    public boolean isGameOver() {
        return model.isGameOver();
    }
}
