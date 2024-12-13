package com.example.gameplay;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calcMoney extends AppCompatActivity {
    private TextView change;
    private TextView taka_1000, taka_500,taka_200, taka_100, 
            taka_50, taka_20, taka_10, taka_5, taka_2, taka_1;
    private EditText bill, paid;
    private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_money);
        findViews();
        noteCalc();
        
    }

    private void noteCalc() {
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int moneyChange = calcChange();
                if (moneyChange > 0){
                    int note_1000 = Math.floorDiv(moneyChange,1000);
                    int change = moneyChange  %  1000;
                    if (note_1000 > 0){
                        taka_1000.setText("1000: "+ note_1000);
                        taka_1000.setTextColor(Color.parseColor("#A020F0"));
                    }

                    int note_500 = Math.floorDiv(change,500);
                    change = change % 500;
                    if (note_500 > 0){
                        taka_500.setText("500: "+ note_500);
                        taka_500.setTextColor(Color.parseColor("#A020F0"));
                    }
                    
                    int note_200 = Math.floorDiv(change,200);
                    change = change % 200;
                    if (note_200 > 0){
                        taka_200.setText("200: "+ note_200);
                        taka_200.setTextColor(Color.parseColor("#A020F0"));
                    }

                    int note_100 = Math.floorDiv(change,100);
                    change = change % 100;
                    if (note_100 > 0){
                        taka_100.setText("100: "+ note_100);
                        taka_100.setTextColor(Color.parseColor("#A020F0"));
                    }

                    int note_50 = Math.floorDiv(change,50);
                    change = change % 50;
                    if (note_50 > 0){
                        taka_50.setText("50: "+ note_50);
                        taka_50.setTextColor(Color.parseColor("#A020F0"));
                    }

                    int note_20 = Math.floorDiv(change,20);
                    change = change % 20;
                    if (note_20 > 0){
                        taka_20.setText("20: "+ note_20);
                        taka_20.setTextColor(Color.parseColor("#A020F0"));
                    }

                    int note_10 = Math.floorDiv(change,10);
                    change = change % 10;
                    if (note_10 > 0){
                        taka_10.setText("10: "+ note_10);
                        taka_10.setTextColor(Color.parseColor("#A020F0"));
                    }

                    int note_5 = Math.floorDiv(change,5);
                    change = change % 5;
                    if (note_5 > 0){
                        taka_5.setText("5: "+ note_5);
                        taka_5.setTextColor(Color.parseColor("#A020F0"));
                    }
                    int note_2 = Math.floorDiv(change,2);
                    change = change % 2;
                    if (note_2 > 0){
                        taka_2.setText("2: "+ note_2);
                        taka_2.setTextColor(Color.parseColor("#A020F0"));
                    }
                    int note_1 = Math.floorDiv(change,1);
                    if (note_1 > 0){
                        taka_1.setText("1: "+ note_1);
                        taka_1.setTextColor(Color.parseColor("#A020F0"));
                    }
                }

            }
        });
    }

    private int calcChange() {
        int totalBill = Integer.parseInt(bill.getText().toString());
        int totalPaid = Integer.parseInt(paid.getText().toString());
        int totalChange = totalPaid - totalBill;
        change.setText(String.valueOf(totalChange));
        return totalChange;
    }

    private void findViews() {
        change = findViewById(R.id.change);
        bill = findViewById(R.id.bill);
        paid = findViewById(R.id.paid);
        calc = findViewById(R.id.calc);
        taka_1000 = findViewById(R.id.taka_1000);
        taka_500 = findViewById(R.id.taka_500);
        taka_200 = findViewById(R.id.taka_200);
        taka_100 = findViewById(R.id.taka_100);
        taka_50 = findViewById(R.id.taka_50);
        taka_20 = findViewById(R.id.taka_20);
        taka_10 = findViewById(R.id.taka_10);
        taka_5 = findViewById(R.id.taka_5);
        taka_2 = findViewById(R.id.taka_2);
        taka_1 = findViewById(R.id.taka_1);
    }
}
