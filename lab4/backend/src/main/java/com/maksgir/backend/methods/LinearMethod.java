package com.maksgir.backend.methods;

import com.maksgir.backend.dto.Point;
import com.maksgir.backend.math.ApproximationCounter;
import com.maksgir.backend.math.GaussSystemSolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LinearMethod {

    private double SX;
    private double SY;
    private double SXX;
    private double SXY;

    @Autowired
    private GaussSystemSolver gauss;
    @Autowired
    private ApproximationCounter apprCounter;

    public double solve(List<Point> points) {
        int n = points.size();

        for (Point p : points) {
            double x = p.getX();
            double y = p.getY();
            SX += x;
            SY += y;
            SXX = x * x;
            SXY = x * y;
        }

        double[][] matrix = new double[2][3];
        matrix[0] = new double[]{SXX, SX, SXY};
        matrix[1] = new double[]{SX, n, SY};
        double[] answer = gauss.solve(matrix);

        double a = answer[0];
        double b = answer[1];

        return apprCounter.count(points, (x -> a * x + b));
    }

}
