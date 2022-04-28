package com.netcracker.homework.ch3.ex1_2;

public class CashRegister {
    private double purchase;
    private double payment;
    private int itemCount;
    private double taxTotal;
    private double tax;

    public CashRegister( double tax) {
        this.tax = tax;
    }

    public void recordPurchase(double amount) {
        purchase = purchase + amount;
        itemCount++;
    }

    public void receivePayment(double amount) {
        payment = payment + amount;
    }

    public double giveChange() {
        double change = payment - (purchase + taxTotal);
        purchase = 0;
        payment = 0;
        taxTotal = 0;

        return change;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void recordTaxablePurchase(double amount){
        purchase = purchase + amount;
        taxTotal = taxTotal + amount * tax;
    }

    public double getTaxTotal() {
        return taxTotal;
    }
}
