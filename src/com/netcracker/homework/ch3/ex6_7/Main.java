package com.netcracker.homework.ch3.ex6_7;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Taehyung");
        System.out.println("My name is "+ person.getName() + " \n\nMy friends are :");


        person.befriend("Jungkook");
        person.befriend("Izumi");
        person.befriend("Jimin");
        person.befriend("Yoon-gi");
        person.befriend("Hoseok");

        System.out.println("count : " + person.getFriendCount());
        System.out.println("\nAnd now my friends  are :");
        person.unfriend("Izumi");
        System.out.println("count : " + person.getFriendCount());



    }

}