package com.example.crud;

public class StudentModel {
    private String name;
    private int rollNmber;

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", rollNmber=" + rollNmber +
                '}';
    }

    public StudentModel(String name, int rollNmber) {
        this.name = name;
        this.rollNmber = rollNmber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNmber() {
        return rollNmber;
    }

    public void setRollNmber(int rollNmber) {
        this.rollNmber = rollNmber;
    }


}
