package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.Controller.motivationController;
import com.example.gameplay.R;

public class motivationView extends AppCompatActivity {

    private motivationController controller;
    private TextView showQuote;
    private Button more, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivate);
        controller = new motivationController(this);
        findViews();
        displayQuote();
        showMoreQuote();
        exitQuote();
    }

    private void exitQuote() {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showMoreQuote() {
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuote();
            }
        });
    }

    private void displayQuote() {
        String quote = controller.getRandomQuote();
        showQuote.setText(quote);
    }

    private void findViews() {
        showQuote = findViewById(R.id.showQuote);
        more = findViewById(R.id.more);
        exit = findViewById(R.id.exit);
    }
}