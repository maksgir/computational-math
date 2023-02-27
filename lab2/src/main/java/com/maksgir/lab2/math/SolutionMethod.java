package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.Answer;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.Equation;

public interface SolutionMethod {

    Answer solveEquation(Equation equation, Interval interval, double epsilon);

}
