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
public class RungeKuttaMethod {

    @Autowired
    private RangesCounter rangesCounter;

    @Autowired
    private RungeApproximation runge;

    private final int p = 4; // порядок точности

    public List<Point> countPoints(InputParams params, DifferentialEquation equation) {

        List<Point> ans = new ArrayList<>();
        ans.add(new Point(params.getX0(), params.getY0()));

        List<Double> xs = rangesCounter.getRangeOfX(params.getX0(), params.getXn(), params.getH());

        for (int i = 1; i < xs.size(); i++) {
            double h = params.getH();
            List<Double> curY = countWithH(equation, xs, params.getY0(), h);
            List<Double> nextY = countWithH(equation, xs, params.getY0(), h / 2);

            while (runge.calculateApproximation(curY.get(i), nextY.get(i), p) > params.getE()){
                h /= 2;
                curY = nextY;
                nextY = countWithH(equation, xs, params.getY0(), h / 2);
            }

            ans.add(new Point(xs.get(i), nextY.get(i)));
        }

        return ans;
    }

    private List<Double> countWithH(DifferentialEquation f, List<Double> xs, double y0, double step){
        List<Double> ys = new ArrayList<>();
        ys.add(y0);

        for (int i = 1; i < xs.size(); i++) {
            double k1 = step * f.getInitFunc().apply(xs.get(i - 1), ys.get(i - 1));
            double k2 = step * f.getInitFunc().apply(xs.get(i - 1) + step / 2, ys.get(i - 1) + k1 / 2);
            double k3 = step * f.getInitFunc().apply(xs.get(i - 1) + step / 2, ys.get(i - 1) + k2 / 2);
            double k4 = step * f.getInitFunc().apply(xs.get(i - 1) + step, ys.get(i - 1) + k3);

            ys.add(ys.get(i-1) + (k1 + 2 * k2 + 2 * k3 + k4) / 6);
        }

        return ys;
    }
}
