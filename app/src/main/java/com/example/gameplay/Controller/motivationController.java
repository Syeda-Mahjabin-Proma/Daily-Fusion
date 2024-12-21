package com.example.gameplay.Controller;

import android.content.Context;

import com.example.gameplay.Model.motivationModel;

import java.util.ArrayList;
import java.util.Random;

public class motivationController {
    private motivationModel model;

    public motivationController(Context context) {
        model = new motivationModel(context);
    }

    public ArrayList<String> getAllQuote() {
        return model.getQuoteList();
    }

    public String getRandomQuote() {
        if (model.getQuoteList().isEmpty()) {
            return "You are Beautiful.";
        }
        Random random = new Random();
        String randomQuote = model.getQuoteList().get(random.nextInt(model.getQuoteList().size()));
        return randomQuote;
    }


}
