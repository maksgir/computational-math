package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.Equation;

public interface EquationSolutionMethod {

    AnswerEquation solveEquation(Equation equation, Interval interval, double epsilon);

}
