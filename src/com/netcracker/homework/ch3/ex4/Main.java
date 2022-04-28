package com.netcracker.homework.ch3.ex4;

public class Main {
    public static void main(String[] args) {
        Sheet sheet = new Sheet(841 , 1189);

        while(sheet.getHeight()>=26 && sheet.getWidth()>=37) {
            System.out.print("A" + sheet.formatA() + " : ");
            sheet.cutInHalf();

        }
    }
}
