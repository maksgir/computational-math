package com.maksgir.backend.math;

import com.maksgir.backend.dto.Point;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


@Component
public class ApproximationCounter {
    public double count(List<Point> points, Function<Double, Double> fi) {
        double s = 0;

        for (Point p : points) {
            s += Math.pow(fi.apply(p.getX()) - p.getY(), 2);
        }

        return Math.sqrt(s / points.size());
    }
}
