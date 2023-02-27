package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.Answer;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.Equation;

public class SecantMethod implements SolutionMethod {
    @Override
    public Answer solveEquation(Equation equation, Interval interval, double epsilon) {

        double x0 = interval.getA();
        double x1 = x0 + 0.03;
        int i = 0;
        double x2 = 0;

        do {
            i++;
            x2 = x1 - ((x1 - x0) / (equation.f(x1) - equation.f(x0)) * equation.f(x1));

            double m = Math.abs(x2 - x1);
            System.out.println(x0 + " " + x1 + " " + x2);
            if (m <= epsilon) {
                break;
            }
            x0 = x1;
            x1 = x2;

        } while (true);

        return new Answer(x2, i);
    }
}
