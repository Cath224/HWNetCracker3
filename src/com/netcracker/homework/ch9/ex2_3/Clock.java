package com.netcracker.homework.ch9.ex2_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Clock {
    private String minutes;
    private String hours;
    private int hoursAlarm;
    private int minutesAlarm;

    public Clock() {
    }

    public String getHours() {
        return java.time.LocalTime.now().toString().substring(0, 2);
    }

    public String getMinutes() {
        return java.time.LocalTime.now().toString().substring(3, 5);
    }

    public String getTime() {
        return getHours() + ":" + getMinutes();
    }


    public void getAlarm() {
        if (Integer.parseInt(getHours()) == this.hoursAlarm && Integer.parseInt(getMinutes()) == this.minutesAlarm) {
            System.out.println("Alarm");
        }
    }

    public void setAlarm(int hoursAlarm, int minutesAlarm) {
        this.hoursAlarm = hoursAlarm;
        this.minutesAlarm = minutesAlarm;
    }


    public void date() {

        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.dd.MM");

        System.out.println("date : " + format.format(nowDate));

    }
}