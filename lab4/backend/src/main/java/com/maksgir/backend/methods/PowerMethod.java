package com.maksgir.backend.methods;

import com.maksgir.backend.dto.Point;

import java.util.List;

public class PowerMethod {


    public Double solve(List<Point> points, LinearMethod linearMethod) {
        for (Point p : points) {
            double x = p.getX();
            double y = p.getY();
            if (y <= 0 || x <= 0) {
                return null;
            }
            p.setX(Math.log(x));
            p.setY(Math.log(y));
        }

        return linearMethod.solve(points);
    }
}
