package com.example.backend.util;


import com.example.backend.dto.InputParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RangesCounter {

    public List<Double> getRangeOfX(double x0, double xn, double step) {
        List<Double> xs = new ArrayList<>();

        int n = countN(x0, xn, step);

        for (int i = 0; i < n; i++) {
            xs.add(x0);
            x0+= step;
        }

        return xs;
    }

    public int countN(double x0, double xn, double step) {
        return (int) Math.ceil((xn - x0) / step) + 1;
    }
}
