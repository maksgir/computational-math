package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.InputData;
import com.maksgir.lab2.equation.Equation;

public interface EquationSolutionMethod {

    AnswerEquation solveEquation(Equation equation, InputData interval);

}
