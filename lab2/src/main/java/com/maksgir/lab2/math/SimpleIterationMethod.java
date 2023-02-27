package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.Answer;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.Equation;

public class SimpleIterationMethod implements SolutionMethod {
    @Override
    public Answer solveEquation(Equation equation, Interval interval, double epsilon) {

        double a = interval.getA();
        double b = interval.getB();

        double aD = equation.fDerivative(a);
        double bD = equation.fDerivative(b);

        double lambda = -1 / Math.max(aD, bD);

        double x0 = b;
        double x1 = fi(x0, equation, lambda);

        int i = 0;

        do {
            i++;
            double x2 = fi(x1, equation, lambda);

            double m = Math.abs(x1 - x0);

            if (m <= epsilon) {
                break;
            }

            x0 = x1;
            x1 = x2;
        } while (true);

        return new Answer(x1, i);
    }

    private double fi(double x, Equation equation, double lambda) {

        return x + lambda * equation.f(x);
    }
}
