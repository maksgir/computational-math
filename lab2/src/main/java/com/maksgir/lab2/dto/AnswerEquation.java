package com.maksgir.lab2.dto;

import com.maksgir.lab2.equation.Equation;

public class AnswerEquation {
    private double x;
    private int i;
    private Equation equation;

    public AnswerEquation(double x, int i, Equation equation) {
        this.x = x;
        this.i = i;
        this.equation = equation;
    }

    @Override
    public String toString() {
        return "Ответ: " +
                "x=" + x +
                ", был получен за " + i +
                " итераций";
    }
}
