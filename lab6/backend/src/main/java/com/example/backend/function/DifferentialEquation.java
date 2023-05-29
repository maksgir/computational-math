package com.example.backend.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.BiFunction;


@Getter
@Setter
@AllArgsConstructor
public class DifferentialEquation {

    private String representation;
    private BiFunction<Double, Double, Double> exactFunc;
    private BiFunction<Double, Double, Double> initFunc;
    private BiFunction<Double, Double, Double> constFunc;

}
