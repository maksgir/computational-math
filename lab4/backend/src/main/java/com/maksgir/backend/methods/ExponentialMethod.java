package com.maksgir.backend.methods;

import com.maksgir.backend.dto.Point;

import java.util.List;

public class ExponentialMethod {

    public Double solve(List<Point> points, LinearMethod linearMethod) {
        for (Point p: points){
            double y = p.getY();
            if (y< 0){
                return null;
            }
            p.setY(Math.log(y));
        }

        return linearMethod.solve(points);
    }

}
