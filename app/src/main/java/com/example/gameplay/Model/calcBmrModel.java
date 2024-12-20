package com.example.gameplay.Model;


public class calcBmrModel {
    public double[] calculateBmr(int feet, float inch, float weight, int age, boolean isMale) {
        double[] bmrHeight = new double[2];

        double totalHeight = ((feet * 12) + inch) * 0.0254;
        double bmr = 0;

        if (isMale) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * totalHeight) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * totalHeight) - (4.330 * age);
        }

        bmrHeight[0] = bmr;
        bmrHeight[1] = totalHeight;
        return bmrHeight;
    }
}
