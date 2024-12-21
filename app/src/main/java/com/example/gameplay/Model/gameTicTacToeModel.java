package com.example.gameplay.Model;

public class gameTicTacToeModel {
    private final String[] board;
    private int player1Score;
    private int player2Score;
    private boolean isPlayer1Turn;

    public gameTicTacToeModel() {
        this.board = new String[9];
        this.player1Score = 0;
        this.player2Score = 0;
        this.isPlayer1Turn = true;
        resetBoard();
    }

    // Reset the game board
    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = "";
        }
    }

    // Check for a win condition
    public boolean checkWin(String symbol) {
        return (board[0].equals(symbol) && board[1].equals(symbol) && board[2].equals(symbol)) ||
                (board[3].equals(symbol) && board[4].equals(symbol) && board[5].equals(symbol)) ||
                (board[6].equals(symbol) && board[7].equals(symbol) && board[8].equals(symbol)) ||
                (board[0].equals(symbol) && board[3].equals(symbol) && board[6].equals(symbol)) ||
                (board[1].equals(symbol) && board[4].equals(symbol) && board[7].equals(symbol)) ||
                (board[2].equals(symbol) && board[5].equals(symbol) && board[8].equals(symbol)) ||
                (board[0].equals(symbol) && board[4].equals(symbol) && board[8].equals(symbol)) ||
                (board[2].equals(symbol) && board[4].equals(symbol) && board[6].equals(symbol));
    }

    public void updateScore(boolean isPlayer1Turn) {
        if (isPlayer1Turn) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String[] getBoard() {
        return board;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public boolean isPlayer1Turn() {
        return isPlayer1Turn;
    }

    public void setIsPlayer1Turn(boolean isPlayer1Turn) {
        this.isPlayer1Turn = isPlayer1Turn;
    }
}
