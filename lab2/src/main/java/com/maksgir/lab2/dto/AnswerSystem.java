package com.maksgir.lab2.dto;

public class AnswerSystem {
    private double x;
    private double y;
    private int i;

    public AnswerSystem(double x, double y, int i) {
        this.x = x;
        this.y = y;
        this.i = i;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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
                "x=" + x + ", " +
                "y=" + y +
                ", был получен за " + i +
                " итераций";
    }
}
