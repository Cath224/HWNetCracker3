package com.netcracker.homework.ch9.ex2_3;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class WorldClock extends Clock{
    private String hoursWorld;
    private String minutesWorld;
    private int timeZone ;
    private int hoursWorldAlarm;
    private int minutesWorldAlarm;


    public WorldClock(int timeZone) {
        super();
        this.timeZone = timeZone;
    }

    public String getHours(){
        int localTimeParse = Integer.parseInt(super.getHours());
        return Integer.toString(localTimeParse + timeZone);
    }

    public String getMinutes(){
        return super.getMinutes();
    }
    public String getTime(){
        return getHours() + ":" + getMinutes();
    }

    public void getAlarm() {
        if (Integer.parseInt(getHours()) == hoursWorldAlarm && Integer.parseInt(getMinutes()) == minutesWorldAlarm) {
            System.out.println("Alarm") ;
        }
    }

    public void setAlarm(int hoursAlarm,int minutesAlarm) {
        hoursWorldAlarm = hoursAlarm + timeZone;
        minutesWorldAlarm = minutesAlarm ;
    }

    public void date() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.dd.MM");
        ZonedDateTime seoulDate = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        System.out.println("date : " + format.format(seoulDate));

    }
}