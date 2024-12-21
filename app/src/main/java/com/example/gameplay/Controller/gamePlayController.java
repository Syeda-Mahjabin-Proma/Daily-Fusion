package com.example.gameplay.Controller;


import android.content.Context;
import android.content.Intent;

import com.example.gameplay.View.gameMemoryView;
import com.example.gameplay.View.gameRightWrongView;
import com.example.gameplay.View.gameRockPaperScissorView;
import com.example.gameplay.View.gameTicTacToeView;
import com.example.gameplay.View.gameWordScrambleView;

public class gamePlayController {
    private final Context context;

    public gamePlayController(Context context) {
        this.context = context;
    }

    public void handleRightWrong() {
        context.startActivity(new Intent(context, gameRightWrongView.class));
    }

    public void handleTicTacToe() {
        context.startActivity(new Intent(context, gameTicTacToeView.class));
    }

    public void handleWordGame() {
        context.startActivity(new Intent(context, gameWordScrambleView.class));
    }

    public void handleMemoryGame() {
        context.startActivity(new Intent(context, gameMemoryView.class));
    }

    public void handleRockPaperScissor() {
        context.startActivity(new Intent(context, gameRockPaperScissorView.class));
    }

}
