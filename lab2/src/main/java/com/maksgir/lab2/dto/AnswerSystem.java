package com.maksgir.lab2.dto;

import com.maksgir.lab2.equation.Equation;
import com.maksgir.lab2.system.SystemTask;

public class AnswerSystem {
    private double x;
    private double y;
    private int i;
    private SystemTask system;

    public AnswerSystem(double x, double y, int i, SystemTask system) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.system = system;
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
