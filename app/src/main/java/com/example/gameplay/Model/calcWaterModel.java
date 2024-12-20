package com.example.gameplay.Model;

public class calcWaterModel {
    public double calculateDailyWaterNeed(float weight) {
        return weight * 0.033; // Water need in liters per kg of body weight
    }
}
