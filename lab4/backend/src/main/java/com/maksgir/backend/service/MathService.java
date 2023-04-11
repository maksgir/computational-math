package com.maksgir.backend.service;

import com.maksgir.backend.dto.Answer;
import com.maksgir.backend.dto.Point;
import com.maksgir.backend.methods.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MathService {

    @Autowired
    private LinearMethod linearMethod;
    @Autowired
    private SquareMethod squareMethod;
    @Autowired
    private CubicMethod cubicMethod;
    @Autowired
    private ExponentialMethod exponentialMethod;
    @Autowired
    private LogarithmicMethod logarithmicMethod;
    @Autowired
    private PowerMethod powerMethod;

    public Answer solve(List<Point> pointList) {
        List<Double> linearList = linearMethod.solve(pointList);
        double linear = linearList.remove(linearList.size() - 1);

        List<Double> squareList = squareMethod.solve(pointList);
        double square = squareList.remove(squareList.size() - 1);

        List<Double> cubicList = cubicMethod.solve(pointList);
        double cubic = cubicList.remove(cubicList.size() - 1);


        List<Double> exponentialList = exponentialMethod.solve(pointList, linearMethod);
        Double exponential;
        if (exponentialList != null) {
            exponential = exponentialList.remove(exponentialList.size() - 1);
        } else {
            exponential = null;
        }

        List<Double> logarithmicList = logarithmicMethod.solve(pointList, linearMethod);
        Double logarithmic;
        if (logarithmicList != null) {
            logarithmic = logarithmicList.remove(logarithmicList.size() - 1);
        } else {
            logarithmic = null;
        }

        List<Double> powerList = powerMethod.solve(pointList, linearMethod);
        Double power;
        if (powerList != null) {
            power = powerList.remove(powerList.size() - 1);
        } else {
            power = null;
        }

        String min = null;

        double[] arr = {linear, square, cubic,
                exponential == null ? Double.MAX_VALUE : exponential,
                logarithmic == null ? Double.MAX_VALUE : logarithmic,
                power == null ? Double.MAX_VALUE : power};
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

        return new Answer(min, linearList, squareList, cubicList, exponentialList, logarithmicList, powerList);
    }

}
