package com.maksgir.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Answer {
    private String best;
    private double linear;
    private double square;
    private double cubic;
    private Double exponential;
    private Double logarithmic;
    private Double power;

    public Answer(String best, double linear, double square, double cubic,
                  Double exponential, Double logarithmic, Double power) {
        this.best = best;
        this.linear = linear;
        this.square = square;
        this.cubic = cubic;
        this.exponential = exponential;
        this.logarithmic = logarithmic;
        this.power = power;
    }
}
