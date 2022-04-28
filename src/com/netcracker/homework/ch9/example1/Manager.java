package com.netcracker.homework.ch9.example1;

public class Manager extends Employee{

    private double  salary;
    private double weeklyBonus;


    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        weeklyBonus = bonus;
    }

    @Override
    public double weeklyPay(int hours)
    {
        return super.weeklyPay(hours) + weeklyBonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getWeeklyBonus() {
        return weeklyBonus;
    }

    public void setWeeklyBonus(double weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }
}

