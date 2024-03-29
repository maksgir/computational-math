package com.maksgir.backend.methods;

import com.maksgir.backend.dto.Point;
import com.maksgir.backend.math.ApproximationCounter;
import com.maksgir.backend.math.GaussSystemSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CubicMethod {
    private double SX;
    private double SY;

    private double S2X;
    private double S3X;
    private double S4X;
    private double S5X;
    private double S6X;

    private double SXY;
    private double SXXY;
    private double SXXXY;

    @Autowired
    private GaussSystemSolver gauss;
    @Autowired
    private ApproximationCounter apprCounter;

    public List<Double> solve(List<Point> points) {
        int n = points.size();

        for (Point p : points) {
            double x = p.getX();
            double y = p.getY();
            SX += x;
            SY += y;

            S2X += x * x;
            SXY += x * y;
            S3X += x * x * x;
            S4X += x * x * x * x;
            S5X += x * x * x * x * x;
            S6X += x * x * x * x * x * x;

            SXXY += x * x * y;
            SXXXY += x * x * x * y;
        }

        double[][] matrix = new double[4][5];
        matrix[0] = new double[]{n, SX, S2X, S3X, SY};
        matrix[1] = new double[]{SX, S2X, S3X, S4X, SXY};
        matrix[2] = new double[]{S2X, S3X, S4X, S5X, SXXY};
        matrix[3] = new double[]{S3X, S4X, S5X, S6X, SXXXY};

        double[] answer = gauss.solve(matrix);

        double x0 = answer[0];
        double x1 = answer[1];
        double x2 = answer[2];
        double x3 = answer[3];

        List<Double> list = new ArrayList(Arrays.asList(x0, x1, x2, x3,
                apprCounter.count(points, x -> (x0 + x1 * x + x2 * x * x + x3 * x * x * x))));

        return list;
    }
}
