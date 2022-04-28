package com.netcracker.homework.ch3.ex1_2;

public class Main {
    public static void main(String[] args) {
        CashRegister register = new CashRegister(0.09);


        register.recordPurchase(29.50);
        register.recordTaxablePurchase(9.25);
        register.receivePayment(50);

        System.out.println("TaxTotal : " + register.getTaxTotal());
        System.out.println("Change : " + register.giveChange());
        System.out.println("ItemCount : " + register.getItemCount());


    }
}
