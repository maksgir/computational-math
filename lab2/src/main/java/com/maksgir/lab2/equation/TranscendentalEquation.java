package com.maksgir.lab2.equation;


import com.maksgir.lab2.equation.Equation;

// pi/2 + 2*k*pi/3     pi/2 + k*pi
public class TranscendentalEquation implements Equation {
    public static String equation = "sin(2x) + cos(x) = 0";

    @Override
    public double solve(double x) {
        return Math.sin(2 * x) + Math.cos(x);
    }
}
