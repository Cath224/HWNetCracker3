package com.netcracker.homework.ch8.ex1;

public class Main {
    public static void main(String[] args) {
        ComboLock comboLock = new ComboLock(29, 10, 38);

        System.out.println("*^*^*^*^*^*^*^*Test 1*^*^*^*^*^*^*^*^*");
        comboLock.turnRight(29);
        System.out.println(comboLock.getNumberCurrent());
        comboLock.turnLeft(19);
        System.out.println(comboLock.getNumberCurrent());
        comboLock.turnRight(28);
        System.out.println(comboLock.getNumberCurrent());

        comboLock.open();
        comboLock.reset();
        comboLock.getMove();
        System.out.println("*^*^*^*^*^*^*^*Test 2*^*^*^*^*^*^*^*^*");

        comboLock.turnRight(10);
        System.out.println(comboLock.getNumberCurrent());
        comboLock.turnLeft(10);
        System.out.println(comboLock.getNumberCurrent());
        comboLock.turnRight(10);
        System.out.println(comboLock.getNumberCurrent());

        comboLock.open();
        comboLock.reset();
        comboLock.getMove();
        System.out.println("*^*^*^*^*^*^*^*Test 3*^*^*^*^*^*^*^*^*");

        comboLock.turnRight(2000);
        System.out.println(comboLock.getNumberCurrent());
        comboLock.turnRight(5000);
        System.out.println(comboLock.getNumberCurrent());
        comboLock.open();

    }
}
