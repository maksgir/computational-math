package com.maksgir.lab2.dto;

public class Answer {
    private double x;
    private int i;

    public Answer(double x, int i) {
        this.x = x;
        this.i = i;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Ответ: " +
                "x=" + x +
                ", был получен за " + i +
                " итераций";
    }
}
