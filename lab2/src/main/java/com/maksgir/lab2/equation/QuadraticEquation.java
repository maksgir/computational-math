package com.maksgir.lab2.equation;


// 1,35435     6,64575
public class QuadraticEquation implements Equation {
    public static String equation = "x^2 - 8*x + 9";


    @Override
    public double solve(double x) {
        return x * x - 8 * x + 9;
    }
}
