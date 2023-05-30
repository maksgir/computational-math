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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
        } catch (Exception e) {
            errorMSG = e.getMessage();
        }

        double xMin = findMinX(exactPoints);
        double xMax = findMaxX(exactPoints);

        double yMin = findMinY(exactPoints);
        double yMax = findMaxY(exactPoints);

        ServiceAnswer answer = new ServiceAnswer(exactPoints, eulerPoints, rungePoints, milnPoints, errorMSG, xMin, xMax, yMin, yMax);
        System.out.println(answer);
        return answer;
    }

    private Double findMinX(List<Point> points) {
        double min = Double.MAX_VALUE;
        for (Point p : points) {
            if (Double.isFinite(p.getX())){
                min = Math.min(p.getX(), min);
            }
        }

        return min;
    }

    private Double findMaxX(List<Point> points) {
        double min = Double.MIN_VALUE;
        for (Point p : points) {
            if (Double.isFinite(p.getX())){
                min = Math.max(p.getX(), min);
            }
        }

        return min;
    }

    private Double findMinY(List<Point> points) {
        double min = Double.MAX_VALUE;
        for (Point p : points) {
            if (Double.isFinite(p.getY())){
                min = Math.min(p.getY(), min);
            }
        }

        return min;
    }

    private Double findMaxY(List<Point> points) {
        double min = Double.MIN_VALUE;
        for (Point p : points) {
            if (Double.isFinite(p.getY())){
                min = Math.max(p.getY(), min);
            }
        }

        return min;
    }

}
