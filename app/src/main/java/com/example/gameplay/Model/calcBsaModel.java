package com.example.gameplay.Model;


public class calcBsaModel {
    public double calculateBsa(int feet, float inches, float weight) {
        double totalHeightCm = ((feet * 12) + inches) * 2.54; // Convert height to cm
        return Math.sqrt((weight * totalHeightCm) / 3600);    // Calculate BSA
    }
}
