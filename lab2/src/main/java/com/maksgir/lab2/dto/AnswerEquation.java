package com.maksgir.lab2.dto;

import com.maksgir.lab2.equation.Equation;

public class AnswerEquation {
    private double x;
    private int i;
    private Equation equation;
    private Interval interval;

    public AnswerEquation(double x, int i, Equation equation, Interval interval) {
        this.x = x;
        this.i = i;
        this.equation = equation;
        this.interval = interval;
    }

    public double getX() {
        return x;
    }

    public Equation getEquation() {
        return equation;
    }

    public Interval getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "Ответ: " +
                "x=" + x +
                ", был получен за " + i +
                " итераций";
    }
}
