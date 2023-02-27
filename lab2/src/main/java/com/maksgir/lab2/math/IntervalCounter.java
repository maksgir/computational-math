package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.Equation;

import java.util.ArrayList;
import java.util.List;

public class IntervalCounter {
    public List<Interval> countIntervals(Equation equation, BigInterval bigInterval) {

        List<Interval> answer = new ArrayList<>();

        for (double i = bigInterval.getA() + 0.5; i < bigInterval.getB(); i += 0.5) {
            double left = equation.f(i - 0.5);
            double right = equation.f(i);
            if (left * right <= 0) {
                answer.add(new Interval(i-0.5, i));
            }
        }

        return answer;
    }
}
