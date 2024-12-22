package com.example.gameplay.Controller;

import com.example.gameplay.Model.moneyChangeModel;
import com.example.gameplay.View.moneyChangeView;

public class moneyChangeController {
    private moneyChangeModel model;
    private moneyChangeView view;

    public moneyChangeController(moneyChangeModel model, moneyChangeView view) {
        this.model = model;
        this.view = view;
    }

    public void calculateChange() {
        int bill = view.getBillAmount();
        int paid = view.getPaidAmount();

        model.setBillAmount(bill);
        model.setPaidAmount(paid);
        model.calculateChange();

        int[] notes = model.getNoteCount();
        view.updateNotes(notes);
    }

    public int getChange(){
        return model.getChangeAmount();
    }

}
