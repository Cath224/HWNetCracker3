package com.netcracker.homework.ch9.example1;

public class Employee {
    private String name;
    private double weeklyPay;

    public Employee(String name, double weeklyPay) {
        this.name = name;
        this.weeklyPay = weeklyPay;
    }

    public Employee() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    public double weeklyPay(int hoursWorked){
        return hoursWorked*(weeklyPay/5);
    }
}
