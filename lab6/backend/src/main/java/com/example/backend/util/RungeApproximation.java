package com.example.backend.util;


import org.springframework.stereotype.Component;

@Component
public class RungeApproximation {

    public Double calculateApproximation(double curY, double nextY, int p){
        return Math.abs(curY - nextY) / (Math.pow(2, p) - 1);
    }
}
