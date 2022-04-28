package com.netcracker.homework.ch9.ex2_3;

public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        System.out.println("Here: ");
        System.out.println("hours : " + clock.getHours() + ", minutes : " + clock.getMinutes());
        System.out.println("time : " + clock.getTime());
        WorldClock worldClock = new WorldClock(6);

        clock.setAlarm(14, 33);
        clock.getAlarm();
        clock.date();


        System.out.println("\nMeanwhile in sunny beautiful Seoul: ");
        System.out.println("hours : " + worldClock.getHours() + ", minutes : " + worldClock.getMinutes());
        System.out.println("time : " + worldClock.getTime());

        worldClock.setAlarm(14, 33);
        worldClock.getAlarm();
        worldClock.date();

    }
}
