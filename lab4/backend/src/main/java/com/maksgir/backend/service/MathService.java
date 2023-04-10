package com.maksgir.backend.service;

import com.maksgir.backend.dto.Answer;
import com.maksgir.backend.dto.Point;
import com.maksgir.backend.methods.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MathService {

    private LinearMethod linearMethod;
    private SquareMethod squareMethod;
    private CubicMethod cubicMethod;
    private ExponentialMethod exponentialMethod;
    private LogarithmicMethod logarithmicMethod;
    private PowerMethod powerMethod;

    public Answer solve(List<Point> pointList) {

        double linear = linearMethod.solve(pointList);
        double square = squareMethod.solve(pointList);
        double cubic = cubicMethod.solve(pointList);
        Double exponential = exponentialMethod.solve(pointList, linearMethod);
        Double logarithmic = logarithmicMethod.solve(pointList, linearMethod);
        Double power = powerMethod.solve(pointList, linearMethod);

        String min = null;

        double[] arr = {linear, square, cubic,
                exponential == null ? 2 : exponential,
                logarithmic == null ? 2 : logarithmic,
                power == null ? 2 : power};
        arr = Arrays.stream(arr).sorted().toArray();

        if (arr[0] == linear) {
            min = "linear";
        } else if (arr[0] == square) {
            min = "square";
        } else if (arr[0] == cubic) {
            min = "cubic";
        } else if (arr[0] == (exponential == null ? 2 : exponential)) {
            min = "exponential";
        } else if (arr[0] == (logarithmic == null ? 2 : logarithmic)) {
            min = "logarithmic";
        } else if (arr[0] == (power == null ? 2 : power)) {
            min = "power";
        }

        return new Answer(min, linear, square, cubic, exponential, logarithmic, power);
    }

}
