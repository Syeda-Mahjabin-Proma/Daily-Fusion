package com.example.gameplay.Controller;

import android.content.Context;
import android.content.Intent;

import com.example.gameplay.View.calcBmiView;
import com.example.gameplay.View.calcBmrView;
import com.example.gameplay.View.calcBsaView;
import com.example.gameplay.View.calcCalBurntView;
import com.example.gameplay.View.calcWaterView;

public class healthCheckController {
    private final Context context;

    public healthCheckController(Context context) {
        this.context = context;
    }

    public void handleBmiCheck() {

        context.startActivity(new Intent(context, calcBmiView.class));
    }

    public void handleBmrCheck() {

        context.startActivity(new Intent(context, calcBmrView.class));
    }

    public void handleWaterIntakeCheck() {
        context.startActivity(new Intent(context, calcWaterView.class));
    }

    public void handleBsaCheck() {

        context.startActivity(new Intent(context, calcBsaView.class));
    }

    public void handleCaloriesBurnedCheck() {
        context.startActivity(new Intent(context, calcCalBurntView.class));
    }
}
