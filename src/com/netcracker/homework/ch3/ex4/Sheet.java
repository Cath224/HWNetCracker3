package com.netcracker.homework.ch3.ex4;

public class Sheet {
    private int width;
    private int height;
    private int format;

    public Sheet(int width, int height) {
        this.width = width;
        this.height = height;

    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void cutInHalf (){
        if (width >=height){
            width = width/2;
            System.out.println(width + "x" + height);
        }else {
            height = height/2;
            System.out.println(height + "x" + width);
        }
    }

    public int formatA(){
        return ++format;
    }

}