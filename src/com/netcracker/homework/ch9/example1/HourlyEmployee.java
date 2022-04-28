package com.netcracker.homework.ch9.example1;

public class HourlyEmployee extends Employee{
    private double  wage;


    public HourlyEmployee(String name,double wage) {
        setName(name);
        this.wage = wage;
    }


    @Override
    public double weeklyPay(int hoursWorked)
    {
        double pay = hoursWorked * wage;
        if (hoursWorked > 40)
        {
            pay = pay + ((hoursWorked - 40) * 0.5) * wage;
        }
        return pay;
    }


    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}

