package com.example.gameplay.Model;

public class gameRockPaperScissorModel {
    private int playerScore = 0;
    private int computerScore = 0;

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissor"};
        int randomChoice = (int) (Math.random() * 3);
        return choices[randomChoice];
    }

    public String determineWinner(String playerChoice, String computerChoice) {
        String result = "";
        if (playerChoice.equals(computerChoice)) {
            playerScore++;
            computerScore++;
            result = " Tie ";
        } else if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                playerScore++;
                result = " YOU ";
            } else if (playerChoice.equals("Scissor")) {
                computerScore++;
                result = " COMPUTER ";
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissor")) {
                playerScore += 1;
                result = " YOU ";
            } else if (playerChoice.equals("Rock")) {
                computerScore += 1;
                result = " COMPUTER ";
            }
        } else if (computerChoice.equals("Scissor")) {
            if (playerChoice.equals("Rock")) {
                playerScore += 1;
                result = " YOU ";
            } else if (playerChoice.equals("Paper")) {
                computerScore += 1;
                result = " COMPUTER ";
            }
        }
        return result;
    }
}
