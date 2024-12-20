package com.example.gameplay.Controller;


import android.content.Context;
import android.content.Intent;

import com.example.gameplay.View.gameRightWrongView;
import com.example.gameplay.View.gameMemoryView;
import com.example.gameplay.rock_paper_scissor;
import com.example.gameplay.tictactoe;
import com.example.gameplay.word_game;

public class gamePlayController {
    private final Context context;

    public gamePlayController(Context context) {
        this.context = context;
    }

    public void handleRightWrong() {
        context.startActivity(new Intent(context, gameRightWrongView.class));
    }

    public void handleTicTacToe() {
        context.startActivity(new Intent(context, tictactoe.class));
    }

    public void handleWordGame() {
        context.startActivity(new Intent(context, word_game.class));
    }

    public void handleMemoryGame() {
        context.startActivity(new Intent(context, gameMemoryView.class));
    }

    public void handleRockPaperScissor() {
        context.startActivity(new Intent(context, rock_paper_scissor.class));
    }

}
