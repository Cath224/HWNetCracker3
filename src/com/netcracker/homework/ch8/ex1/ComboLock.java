package com.netcracker.homework.ch8.ex1;

public class ComboLock {


    private final int[] numbersLock = new int [3];
    private final String[] spin = new String[3];
    private  int[] numbersDialed = new int [3];
    private boolean unlocked = false;
    private int numberCurrent;
    private int move;

    public ComboLock( int secret1, int secret2, int secret3) {
        numbersLock[0] = secret1;
        numbersLock[1] = secret2;
        numbersLock[2] = secret3;
    }

    public void reset() {
        numberCurrent = 0;
    }
    public int getNumberCurrent() {
        return numberCurrent;
    }
    public int getMove() {
        if (move >= 3){
            move = 0;
        }
        return move;
    }

    public void turnRight(int ticks) {
        if ((numberCurrent + ticks) <= 39) {
            numberCurrent += ticks;
        } else {
            numberCurrent = (ticks + numberCurrent)%39;
        }

        if (move == 0) {
            numbersDialed[0] = numberCurrent;
            move++;
        }else{
            numbersDialed[2] = numberCurrent;
            move++;
        }

        spin[0] = "right";
        spin[2] = "right";
    }
    public void turnLeft(int ticks)
    {
        if((numberCurrent - ticks) >= 0) {
            numberCurrent -= ticks;
        } else {
            numberCurrent = 39 - Math.abs(numberCurrent-ticks);
        }
        numbersDialed[1]= numberCurrent;
        spin[1] = "left";
        move++;
    }
    public void open() {
        int checkCombination = 0;
        if (spin[0] == "right" && spin[1] == "left" && spin[2] == "right") {
            for (int i = 0; i < 3; i++) {
                if (numbersDialed[i] == numbersLock[i]) {
                    checkCombination++;

                }
            }
        }
        System.out.println(lock(checkCombination));
    }


    public boolean lock(int checkCombination){
        unlocked = checkCombination == 3;
        return unlocked;
    }

}
