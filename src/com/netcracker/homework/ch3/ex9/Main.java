package com.netcracker.homework.ch3.ex9;

public class Main {
    public static void main(String[] args) {
        Battery battery =new Battery(2700);

        battery.drain(2700);
        battery.drain(50);
        battery.drain(300);

        System.out.println(battery.getRemainingCapacity());

        battery.drain(300.7);

        System.out.println(battery.getRemainingCapacity());

        battery.charge();

        System.out.println(battery.getRemainingCapacity());

    }
}