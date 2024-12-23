package com.example.gameplay.View;

import android.graphics.Color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gameplay.Controller.moneyChangeController;
import com.example.gameplay.Model.moneyChangeModel;
import com.example.gameplay.R;

public class moneyChangeView extends Activity {
    private TextView change;
    private TextView taka_1000, taka_500, taka_200, taka_100,
            taka_50, taka_20, taka_10, taka_5, taka_2, taka_1;
    private EditText bill, paid;
    private Button calc, reCalc;
    private moneyChangeController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_change);
        findViews();

        moneyChangeModel model = new moneyChangeModel();
        controller = new moneyChangeController(model, this);

        setUpListeners();
    }

    private void setUpListeners() {
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.calculateChange();
            }
        });

        reCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bill.setText("");
                paid.setText("");
                change.setText("00 TAKA");
                taka_1000.setText("1000: 0");
                taka_1000.setTextColor(Color.BLACK);
                taka_500.setText("500: 0");
                taka_500.setTextColor(Color.BLACK);
                taka_200.setText("200: 0");
                taka_200.setTextColor(Color.BLACK);
                taka_100.setText("100: 0");
                taka_100.setTextColor(Color.BLACK);
                taka_50.setText("50: 0");
                taka_50.setTextColor(Color.BLACK);
                taka_20.setText("20: 0");
                taka_20.setTextColor(Color.BLACK);
                taka_10.setText("10: 0");
                taka_10.setTextColor(Color.BLACK);
                taka_5.setText("5: 0");
                taka_5.setTextColor(Color.BLACK);
                taka_2.setText("2: 0");
                taka_2.setTextColor(Color.BLACK);
                taka_1.setText("1: 0");
                taka_1.setTextColor(Color.BLACK);
                Toast.makeText(moneyChangeView.this, "Reset Done!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getBillAmount() {
        String billText = bill.getText().toString();
        if (!billText.isEmpty()) {
            return Integer.parseInt(billText);
        } else {
            Toast.makeText(this, "Please Enter Total Bill", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    public int getPaidAmount() {
        String paidText = paid.getText().toString();
        if (!paidText.isEmpty()) {
            return Integer.parseInt(paidText);
        } else {
            Toast.makeText(this, "Enter Paid Amount", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    public void updateNotes(int[] notes) {
        int getChange = controller.getChange();
        change.setText(getChange + " TAKA ");
        taka_1000.setText("1000: " + notes[0]);
        taka_500.setText("500: " + notes[1]);
        taka_200.setText("200: " + notes[2]);
        taka_100.setText("100: " + notes[3]);
        taka_50.setText("50: " + notes[4]);
        taka_20.setText("20: " + notes[5]);
        taka_10.setText("10: " + notes[6]);
        taka_5.setText("5: " + notes[7]);
        taka_2.setText("2: " + notes[8]);
        taka_1.setText("1: " + notes[9]);

        if (notes[0] != 0) {
            taka_1000.setTextColor(Color.RED);
        } else {
            taka_1000.setTextColor(Color.BLACK);
        }
        if (notes[1] != 0) {
            taka_500.setTextColor(Color.RED);
        } else {
            taka_500.setTextColor(Color.BLACK);
        }

        if (notes[2] != 0) {
            taka_200.setTextColor(Color.RED);
        } else {
            taka_200.setTextColor(Color.BLACK);
        }

        if (notes[3] != 0) {
            taka_100.setTextColor(Color.RED);
        } else {
            taka_100.setTextColor(Color.BLACK);
        }

        if (notes[4] != 0) {
            taka_50.setTextColor(Color.RED);
        } else {
            taka_50.setTextColor(Color.BLACK);
        }
        if (notes[5] != 0) {
            taka_20.setTextColor(Color.RED);
        } else {
            taka_20.setTextColor(Color.BLACK);
        }
        if (notes[6] != 0) {
            taka_10.setTextColor(Color.RED);
        } else {
            taka_10.setTextColor(Color.BLACK);
        }
        if (notes[7] != 0) {
            taka_5.setTextColor(Color.RED);
        } else {
            taka_5.setTextColor(Color.BLACK);
        }
        if (notes[8] != 0) {
            taka_2.setTextColor(Color.RED);
        } else {
            taka_2.setTextColor(Color.BLACK);
        }
        if (notes[9] != 0) {
            taka_1.setTextColor(Color.RED);
        } else {
            taka_1.setTextColor(Color.BLACK);
        }


        if (getChange != 0){
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        }
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
