package com.example.gameplay.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class gameWordScrambleModel {
    private final ArrayList<String> words;
    private String currentWord;
    private String shuffledWord;
    private int score = 0;
    private int lives = 3;

    public gameWordScrambleModel(ArrayList<String> words) {
        this.words = words;
        setNewWord();
    }

    public void setNewWord() {
        Random random = new Random();
        currentWord = words.get(random.nextInt(words.size()));
        shuffledWord = shuffleWord(currentWord);
    }

    private String shuffleWord(String word) {
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder shuffled = new StringBuilder();
        for (char c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }

    public boolean checkPlayerGuess(String playerGuess) {
        if (playerGuess.equalsIgnoreCase(currentWord)) {
            score++;
            setNewWord();
            return true;
        } else {
            lives--;
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public String getShuffledWord() {
        return shuffledWord;
    }

    public String getCurrentWord() {
        return currentWord;
    }
}
