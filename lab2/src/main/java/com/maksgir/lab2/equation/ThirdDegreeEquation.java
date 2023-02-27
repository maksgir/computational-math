package com.maksgir.lab2.equation;

import com.maksgir.lab2.equation.Equation;

public class ThirdDegreeEquation implements Equation {
    public static String equation = "x^3 + 2,28*x^2 − 1,934*x − 3,907";

    @Override
    public double f(double x) {
        return x * x * x + 2.28 * x * x - 1.934 * x - 3.907;
    }
}
