package com.example.backend.method;

import com.example.backend.dto.InputParams;
import com.example.backend.dto.Point;
import com.example.backend.exception.ValueException;
import com.example.backend.function.DifferentialEquation;
import com.example.backend.util.RangesCounter;
import com.example.backend.util.RungeApproximation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MilnMethod {

    @Autowired
    private RangesCounter rangesCounter;

    public List<Point> countPoints(InputParams params, DifferentialEquation equation, List<Point> rungeResult) {

        List<Double> xs = rangesCounter.getRangeOfX(params.getX0(), params.getXn(), params.getH());

        if (xs.size() < 4) {
            throw new ValueException("For Milan differentiation num of intervals has to be at least 4");
        }

        List<Double> y = new ArrayList<>();
        List<Point> ans = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ans.add(rungeResult.get(i));
            y.add(rungeResult.get(i).getY());
        }

        for (int i = 4; i < xs.size(); i++) {
            double predict = getPrediction(params.getH(), equation, xs, y, i);
            double correction = getCorrection(params.getH(), equation, xs, y, i, predict);

            while (Math.abs(correction - predict) > params.getH()) {
                predict = correction;
                correction = getCorrection(params.getH(), equation, xs, y, i, predict);
            }

            y.add(correction);
            ans.add(new Point(xs.get(i), correction));
        }

        return ans;
    }

    private double getPrediction(double step, DifferentialEquation f, List<Double> x, List<Double> y, int i) {
        double tmp = 2 * f.getInitFunc().apply(x.get(i - 3), y.get(i - 3)) - f.getInitFunc().apply(x.get(i - 2), y.get(i - 2)) +
                2 * f.getInitFunc().apply(x.get(i - 1), y.get(i - 1));

        return y.get(i - 4) + 4 * step * tmp / 3;
    }

    private double getCorrection(double step, DifferentialEquation f, List<Double> x, List<Double> y, int i, double prediction) {
        double tmp = f.getInitFunc().apply(x.get(i - 2), y.get(i - 2)) + 4 * f.getInitFunc().apply(x.get(i - 1), y.get(i - 1)) +
                f.getInitFunc().apply(x.get(i), prediction);

        return y.get(i - 2) + step * tmp / 3;
    }
}
