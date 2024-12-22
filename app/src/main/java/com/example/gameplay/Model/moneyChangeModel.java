package com.example.gameplay.Model;

public class moneyChangeModel {
    private int billAmount;
    private int paidAmount;
    private int changeAmount;

    public moneyChangeModel() {
        billAmount = 0;
        paidAmount = 0;
        changeAmount = 0;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void calculateChange() {
        this.changeAmount = paidAmount - billAmount;
        if (this.changeAmount < 0) {
            this.changeAmount = 0;
        }
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public int[] getNoteCount() {
        int[] notes = new int[10];
        int change = changeAmount;

        notes[0] = Math.floorDiv(change, 1000);
        change = change % 1000;

        notes[1] = Math.floorDiv(change, 500);
        change = change % 500;

        notes[2] = Math.floorDiv(change, 200);
        change = change % 200;

        notes[3] = Math.floorDiv(change, 100);
        change = change % 100;

        notes[4] = Math.floorDiv(change, 50);
        change = change % 50;

        notes[5] = Math.floorDiv(change, 20);
        change = change % 20;

        notes[6] = Math.floorDiv(change, 10);
        change = change % 10;

        notes[7] = Math.floorDiv(change, 5);
        change = change % 5;

        notes[8] = Math.floorDiv(change, 2);
        change = change % 2;

        notes[9] = Math.floorDiv(change, 1);

        return notes;
    }
}
