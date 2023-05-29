package com.example.backend.util;


import com.example.backend.dto.InputParams;
import com.example.backend.dto.Point;
import com.example.backend.function.DifferentialEquation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExactValuesCounter {

    @Autowired
    private RangesCounter rangesCounter;

    public List<Point> countExactPoints(InputParams input, DifferentialEquation equation) {

        double c = equation.getConstFunc().apply(input.getY0(), input.getX0());

        List<Point> exactPoints = new ArrayList<>();

        for (Double x : rangesCounter.getRangeOfX(input.getX0(), input.getXn(), input.getH())) {
            double y = equation.getExactFunc().apply(x, c);

            exactPoints.add(new Point(x, y));
        }

        return exactPoints;
    }
}
