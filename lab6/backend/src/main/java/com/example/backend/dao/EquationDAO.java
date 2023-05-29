package com.example.backend.dao;


import com.example.backend.function.DifferentialEquation;
import org.springframework.stereotype.Repository;

import java.util.function.BiFunction;

@Repository
public class EquationDAO {

    public DifferentialEquation getEquation(int id) {

        return switch (id) {
            case 1 -> getFirstEquation();
            case 2 -> getSecondEquation();
            case 3 -> getThirdEquation();
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    private DifferentialEquation getFirstEquation() {
        String representation = "y' = x + y";
        BiFunction<Double, Double, Double> exactFunc = (x, c) -> ((-1) * x - 1 + c * Math.exp(x));
        BiFunction<Double, Double, Double> initFunc = (x, y) -> (x + y);
        BiFunction<Double, Double, Double> constFunc = (x, y) -> (y + x + 1) * Math.exp(-x);

        return new DifferentialEquation(representation, exactFunc, initFunc, constFunc);
    }

    private DifferentialEquation getSecondEquation() {
        String representation = "y' = x^2 + y";
        BiFunction<Double, Double, Double> exactFunc = (x, c) -> ((-1) * x * x - 2 * x - 2 + c * Math.exp(x));
        BiFunction<Double, Double, Double> initFunc = (x, y) -> (x * x + y);
        BiFunction<Double, Double, Double> constFunc = (x, y) -> (y + x * x + 2 * x + 2) / Math.exp(x);

        return new DifferentialEquation(representation, exactFunc, initFunc, constFunc);
    }

    private DifferentialEquation getThirdEquation() {
        String representation = "y' = y + (1 + x) * y^2";
        BiFunction<Double, Double, Double> exactFunc = (x, c) -> (-(Math.exp(x)) / (c + Math.exp(x) * x));
        BiFunction<Double, Double, Double> initFunc = (x, y) -> (y + (1 + x) * y * y);
        BiFunction<Double, Double, Double> constFunc = (x, y) -> (-Math.exp(x) - y * Math.exp(x) * x) / y;

        return new DifferentialEquation(representation, exactFunc, initFunc, constFunc);
    }

}
