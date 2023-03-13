package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.AnswerSystem;
import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.system.SystemTask;

import java.util.List;
import java.util.function.BiFunction;

public class NewtonSystemMethod implements SystemSolutionMethod {

    @Override
    public AnswerSystem proceed(BigInterval interval, SystemTask system) {

        GaussSystemSolver gauss = new GaussSystemSolver();

        double x0 = interval.getA();
        double y0 = interval.getB();

        float e = 0.01f;

        List<List<BiFunction<Double, Double, Double>>> jeko = system.getJe();

        double[][] matrix = new double[2][3];

        double x1 = 0;
        double y1 = 0;
        int it = 0;

        do {
            it++;
            for (int i = 0; i < jeko.size(); i++) {
                for (int j = 0; j < jeko.get(i).size(); j++) {
                    matrix[i][j] = jeko.get(i).get(j).apply(x0, y0);
                }
            }

            double[] answer = gauss.solve(matrix);

            x1 = answer[0] + x0;
            y1 = answer[1] + y0;


            if (Math.abs(x1 - x0) <= e && Math.abs(y1 - y0) <= e) {
                break;
            }

            x0 = x1;
            y0 = y1;

        } while (true);


        return new AnswerSystem(x1, y1, it, system, interval);
    }

}
