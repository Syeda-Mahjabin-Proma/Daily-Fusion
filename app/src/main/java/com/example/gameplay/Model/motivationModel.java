package com.example.gameplay.Model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class motivationModel {
    private ArrayList<String> quoteList;

    public motivationModel(Context context) {
        quoteList = new ArrayList<>();
        loadQuotesFromAssets(context);
    }

    private void loadQuotesFromAssets(Context context) {
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open("quotes.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    quoteList.add(line.trim());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getQuoteList() {
        return quoteList;
    }

    public String getRandomQuote() {
        if (quoteList.isEmpty()) {
            return "You are Beautiful.";
        }
        Random random = new Random();
        String randomQuote = quoteList.get(random.nextInt(quoteList.size()));
        return randomQuote;
    }
}
