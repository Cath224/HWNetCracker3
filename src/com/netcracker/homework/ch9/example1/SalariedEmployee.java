package com.netcracker.homework.ch9.example1;

public class SalariedEmployee extends  Employee{
    private double  annualSalary;

    public SalariedEmployee(String name, double salary)
    {
        setName(name);
        annualSalary = salary;
    }

    @Override
    public double weeklyPay(int hoursWorked)
    {
        final int WEEKS_PER_YEAR = 52;
        return annualSalary / WEEKS_PER_YEAR;
    }

    public double getSalary() {
        return annualSalary;
    }

    public void setSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
}
