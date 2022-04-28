package com.netcracker.homework.ch3.ex8;

public class Student {
    private String name;
    private double totalScore;
    private int numberQuizzes;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void addQuiz(double score){
        totalScore += score;
        numberQuizzes++;
    }
    public double getAverageScore(){
        double averageScore = totalScore / numberQuizzes;
        return averageScore;
    }

}