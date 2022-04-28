package com.netcracker.homework.ch3.ex9;

public class Battery {
    private double batteryLevelCharged;
    private double batteryFullCharged;

    public Battery(double batteryFullCharged) {

        this.batteryLevelCharged = batteryFullCharged;
        this.batteryFullCharged = batteryFullCharged;
    }

    public double getRemainingCapacity() {
        return batteryLevelCharged;
    }

    public double getBatteryFullCharged() {
        return batteryFullCharged;
    }

    public void drain(double amount) {
        batteryLevelCharged -= amount;
        if (batteryLevelCharged <= 0){
            charge();
        }
    }

    public void charge() {
        batteryLevelCharged = batteryFullCharged;
    }
}
