package com.example.backend.method;


import com.example.backend.dto.InputParams;
import com.example.backend.dto.Point;
import com.example.backend.function.DifferentialEquation;
import com.example.backend.util.RangesCounter;
import com.example.backend.util.RungeApproximation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModifiedEulerMethod {

    @Autowired
    private RangesCounter rangesCounter;

    @Autowired
    private RungeApproximation runge;

    private final int p = 2; // порядок точности


    public List<Point> countPoints(InputParams params, DifferentialEquation equation) {

        List<Double> xs = rangesCounter.getRangeOfX(params.getX0(), params.getXn(), params.getH());

        List<Point> ans = new ArrayList<>();
        ans.add(new Point(params.getX0(), params.getY0()));

        for (int i = 1; i < xs.size(); i++) {
            double h = params.getH();
            List<Double> curY = countWithH(equation, xs, params.getY0(), h);
            List<Double> nextY = countWithH(equation, xs, params.getY0(), h / 2);

            while (runge.calculateApproximation(curY.get(i), nextY.get(i), p) > params.getE()) {
                h /= 2;
                curY = nextY;
                nextY = countWithH(equation, xs, params.getY0(), h / 2);
            }

            ans.add(new Point(xs.get(i), nextY.get(i)));
        }

        return ans;
    }

    private List<Double> countWithH(DifferentialEquation equation, List<Double> xs, double y0, double step) {
        List<Double> ys = new ArrayList<>();
        ys.add(y0);

        for (int i = 1; i < xs.size(); i++) {
            ys.add(ys.get(i - 1)
                    + (step / 2) * (equation.getInitFunc().apply(xs.get(i - 1), ys.get(i - 1)) +
                    equation.getInitFunc().apply(xs.get(i), ys.get(i - 1) + step * equation.getInitFunc().apply(xs.get(i - 1), ys.get(i - 1)))));
        }

        return ys;
    }


}
