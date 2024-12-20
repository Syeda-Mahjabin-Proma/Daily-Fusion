package com.example.gameplay.Model;

import java.util.Random;

public class gameRightWrongModel {
    private int firstVal;
    private int secondVal;
    private int thirdVal;
    private int life;
    private int score;

    public gameRightWrongModel() {
        this.life = 3;
        this.score = 0;
        generateValues();
    }

    public void generateValues() {
        Random random = new Random();
        firstVal = random.nextInt(50) + 1;
        secondVal = random.nextInt(50) + 1;
        boolean isSum = random.nextBoolean();

        if (isSum) {
            thirdVal = firstVal + secondVal;
        } else {
            do {
                thirdVal = random.nextInt(100) + 1;
            } while (thirdVal == firstVal + secondVal);
        }
    }

    public int getFirstVal() {
        return firstVal;
    }

    public int getSecondVal() {
        return secondVal;
    }

    public int getThirdVal() {
        return thirdVal;
    }

    public int getLife() {
        return life;
    }

    public int getScore() {
        return score;
    }

    public boolean isAnswerCorrect(boolean userAnswer) {
        boolean actualAnswer = (firstVal + secondVal) == thirdVal;
        if (userAnswer == actualAnswer) {
            score++;
            return true;
        } else {
            life--;
            return false;
        }
    }

    public boolean isGameOver() {
        return life <= 0;
    }
}
