package com.netcracker.homework.ch3.ex8;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Seok-jin");

        student.addQuiz(40);
        student.addQuiz(2.9);
        student.addQuiz(10);
        student.addQuiz(30.7);


        System.out.println("Name student : "+ student.getName() +
                "\nTotalScore : "+ student.getTotalScore() +
                "\nAverageScore : " + student.getAverageScore());
    }
}
