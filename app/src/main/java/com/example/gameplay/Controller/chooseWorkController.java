package com.example.gameplay.Controller;

import android.content.Context;
import android.content.Intent;

import com.example.gameplay.View.gamePlayView;
import com.example.gameplay.View.healthCheckView;
import com.example.gameplay.View.motivationView;
import com.example.gameplay.calcMoney;
import com.example.gameplay.toDoView;

public class chooseWorkController {
    private final Context context;

    public chooseWorkController(Context context) {
        this.context = context;
    }

    public void handlePlayGame() {
        context.startActivity(new Intent(context, gamePlayView.class));
    }

    public void handleWeightCheck() {
        context.startActivity(new Intent(context, healthCheckView.class));
    }

    public void handleWorkList() {
        context.startActivity(new Intent(context, toDoView.class));
    }

    public void handleMotivation() {
        context.startActivity(new Intent(context, motivationView.class));
    }

    public void handleMoneyCalculate() {
        context.startActivity(new Intent(context, calcMoney.class));
    }
}
