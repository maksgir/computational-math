package com.maksgir.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Answer {
    private String best;
    private List<Double> linear;
    private List<Double> square;
    private List<Double> cubic;
    private List<Double> exponential;
    private List<Double> logarithmic;
    private List<Double> power;

    public Answer(String best, List<Double> linear, List<Double> square, List<Double> cubic, List<Double> exponential, List<Double> logarithmic, List<Double> power) {
        this.best = best;
        this.linear = linear;
        this.square = square;
        this.cubic = cubic;
        this.exponential = exponential;
        this.logarithmic = logarithmic;
        this.power = power;
    }
}
