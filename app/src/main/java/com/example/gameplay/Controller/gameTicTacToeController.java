package com.example.gameplay.Controller;

import com.example.gameplay.Model.gameTicTacToeModel;
import com.example.gameplay.View.gameTicTacToeView;

public class gameTicTacToeController {
    private final gameTicTacToeModel model;
    private final gameTicTacToeView view;

    public gameTicTacToeController(gameTicTacToeModel model, gameTicTacToeView view) {
        this.model = model;
        this.view = view;
    }

    public void onBoxClick(int index) {
        if (view.isGameOver() || !model.getBoard()[index].equals("")) return;

        String currentPlayer = model.isPlayer1Turn() ? "X" : "O";
        model.getBoard()[index] = currentPlayer;
        view.updateBox(index, currentPlayer);

        if (model.checkWin(currentPlayer)) {
            model.updateScore(model.isPlayer1Turn());
            view.displayWinner(currentPlayer);
            view.updateScores(model.getPlayer1Score(), model.getPlayer2Score());
            view.highlightWinningCells(currentPlayer);
        } else {
            model.setIsPlayer1Turn(!model.isPlayer1Turn());
            view.updateScores(model.getPlayer1Score(), model.getPlayer2Score());
        }
    }

    public void resetGame() {
        model.resetBoard();
        model.setIsPlayer1Turn(true);
        view.resetGameUI();
        view.updateScores(model.getPlayer1Score(), model.getPlayer2Score());
    }
}
