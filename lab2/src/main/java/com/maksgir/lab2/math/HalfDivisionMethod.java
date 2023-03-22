package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.InputData;
import com.maksgir.lab2.equation.Equation;

public class HalfDivisionMethod implements EquationSolutionMethod {
    @Override
    public AnswerEquation solveEquation(Equation equation, InputData interval) {
        double a = interval.getA();
        double b = interval.getB();
        double x ;
        double epsilon = interval.getEpsilon();

        int i = 0;
        do {
            i++;
            x = (a + b) / 2;

            if (equation.f(a) * equation.f(x) > 0) {
                a = x;
            } else {
                b = x;
            }
        } while (!(Math.abs(a - b) <= epsilon) || !(Math.abs(equation.f(x)) < epsilon));

        return new AnswerEquation(x, i, equation, interval );

    }
}




