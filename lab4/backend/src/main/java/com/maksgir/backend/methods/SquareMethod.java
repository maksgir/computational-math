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
public class SquareMethod {

    private double SX;
    private double SY;

    private double SXX;
    private double SXXX;
    private double SXXXX;

    private double SXY;
    private double SXXY;


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
            SXX += x * x;
            SXY += x * y;
            SXXX += x * x * x;
            SXXXX += x * x * x * x;
            SXXY += x * x * y;
        }

        double[][] matrix = new double[3][4];
        matrix[0] = new double[]{n, SX, SXX, SY};
        matrix[1] = new double[]{SX, SXX, SXXX, SXY};
        matrix[2] = new double[]{SXX, SXXX, SXXXX, SXXY};
        double[] answer = gauss.solve(matrix);


        double x0 = answer[0];
        double x1 = answer[1];
        double x2 = answer[2];

        List<Double> list = new ArrayList(Arrays.asList(x0, x1, x2,
                apprCounter.count(points, x -> (x0 + x1 * x + x2 * x * x))));

        return list;
    }
}
