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
public class LinearMethod {

    private double SX;
    private double SY;
    private double SXX;
    private double SXY;

    @Autowired
    private GaussSystemSolver gauss;
    @Autowired
    private ApproximationCounter apprCounter;

    public List<Double> solve(List<Point> points) {
        int n = points.size();

        for (Point p : points) {
            System.out.println(p);
            double x = p.getX();
            double y = p.getY();
            SX += x;
            SY += y;
            SXX += x * x;
            SXY += x * y;
        }

        double[][] matrix = new double[2][3];
        matrix[0] = new double[]{SXX, SX, SXY};
        matrix[1] = new double[]{SX, n, SY};
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));

        double[] answer = gauss.solve(matrix);

        System.out.println(Arrays.toString(answer));

        double a = answer[0];
        double b = answer[1];

        List<Double> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(apprCounter.count(points, (x -> a * x + b)));


        return list;
    }

}
