package com.example.backend.service;


import com.example.backend.dao.EquationDAO;
import com.example.backend.dto.InputParams;
import com.example.backend.dto.Point;
import com.example.backend.dto.ServiceAnswer;
import com.example.backend.function.DifferentialEquation;
import com.example.backend.method.MilnMethod;
import com.example.backend.method.ModifiedEulerMethod;
import com.example.backend.method.RungeKuttaMethod;
import com.example.backend.util.ExactValuesCounter;
import com.example.backend.util.RangesCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolvingService {

    @Autowired
    private EquationDAO dao;

    @Autowired
    private ExactValuesCounter exactValuesCounter;

    @Autowired
    private ModifiedEulerMethod eulerMethod;

    @Autowired
    private RungeKuttaMethod rungeMethod;

    @Autowired
    private MilnMethod milnMethod;

    public ServiceAnswer solve(InputParams input) {

        DifferentialEquation equation = dao.getEquation(input.getFunctionId());

        List<Point> exactPoints = exactValuesCounter.countExactPoints(input, equation);
        List<Point> eulerPoints = eulerMethod.countPoints(input, equation);
        List<Point> rungePoints = rungeMethod.countPoints(input, equation);

        List<Point> milnPoints = null;
        String errorMSG = null;
        try {
            milnPoints = milnMethod.countPoints(input, equation, rungePoints);
        } catch (Exception e){
            errorMSG = e.getMessage();
        }

        return new ServiceAnswer(exactPoints, eulerPoints, rungePoints, milnPoints, errorMSG);
    }

}
