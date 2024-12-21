package com.example.gameplay.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameplay.R;

public class moneyChangeView extends AppCompatActivity {
    private TextView change;
    private TextView taka_1000, taka_500, taka_200, taka_100,
            taka_50, taka_20, taka_10, taka_5, taka_2, taka_1;
    private EditText bill, paid;
    private Button calc, reCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_change);
        findViews();
        noteCalc();
        notereCalc();

    }

    private void notereCalc() {
        reCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void noteCalc() {
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int moneyChange = calcChange();
                if (moneyChange > 0) {
                    Toast.makeText(moneyChangeView.this, "Done", Toast.LENGTH_SHORT).show();
                }

                int note_1000 = Math.floorDiv(moneyChange, 1000);
                int change = moneyChange % 1000;
                taka_1000.setText("1000: " + note_1000);

                int note_500 = Math.floorDiv(change, 500);
                change = change % 500;
                taka_500.setText("500: " + note_500);

                int note_200 = Math.floorDiv(change, 200);
                change = change % 200;
                taka_200.setText("200: " + note_200);

                int note_100 = Math.floorDiv(change, 100);
                change = change % 100;
                taka_100.setText("100: " + note_100);

                int note_50 = Math.floorDiv(change, 50);
                change = change % 50;
                taka_50.setText("50: " + note_50);

                int note_20 = Math.floorDiv(change, 20);
                change = change % 20;
                taka_20.setText("20: " + note_20);

                int note_10 = Math.floorDiv(change, 10);
                change = change % 10;
                taka_10.setText("10: " + note_10);

                int note_5 = Math.floorDiv(change, 5);
                change = change % 5;
                taka_5.setText("5: " + note_5);

                int note_2 = Math.floorDiv(change, 2);
                change = change % 2;
                taka_2.setText("2: " + note_2);

                int note_1 = Math.floorDiv(change, 1);
                taka_1.setText("1: " + note_1);
            }
        });
    }

    private int calcChange() {
        int totalChange;
        String totalBill = bill.getText().toString();
        String totalPaid = paid.getText().toString();

        if (totalBill.isEmpty() || totalPaid.isEmpty()) {
            totalChange = 0;
            Toast.makeText(this, "Enter Total Bill & Total Paid Properly", Toast.LENGTH_SHORT).show();
        } else {
            int intTotalBill = Integer.parseInt(totalBill);
            int intTotalPaid = Integer.parseInt(totalPaid);
            totalChange = intTotalPaid - intTotalBill;
            if (totalChange < 0) {
                totalChange = 0;
                Toast.makeText(this, "Re-Check!!!", Toast.LENGTH_SHORT).show();
            }
        }
        change.setText(String.valueOf(totalChange));
        return totalChange;
    }

    private void findViews() {
        change = findViewById(R.id.change);
        bill = findViewById(R.id.bill);
        paid = findViewById(R.id.paid);
        calc = findViewById(R.id.calc);
        reCalc = findViewById(R.id.recalc);
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