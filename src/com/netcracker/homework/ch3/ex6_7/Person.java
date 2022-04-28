package com.netcracker.homework.ch3.ex6_7;

public class Person {

    private String name;
    private String friendNames;
    private int friendCount;


    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getFriendNames() {
        return friendNames;
    }
    public int getFriendCount(){
        return friendCount;
    }


    public void befriend(String friendName){
        friendNames = friendNames + " " + friendName;
        friendCount++;
        System.out.print(friendName+" " );

    }

    public void unfriend(String name) {

        String[] arrayFriends = friendNames.split(" ");
        loop : for (int i = 1; i < arrayFriends.length; i++) {
            if (arrayFriends[i].equals(name)) {
                friendCount--;
                for (int j = i; j < arrayFriends.length-1; j++) {
                    arrayFriends[i] = arrayFriends[i++];
                    System.out.print(arrayFriends[i]+ " ");
                }
                break loop;

            }
            System.out.print(arrayFriends[i]+" ");
        }
    }
}