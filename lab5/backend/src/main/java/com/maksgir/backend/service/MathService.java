package com.maksgir.backend.service;

import com.maksgir.backend.dto.Answer;
import com.maksgir.backend.dto.Point;
import com.maksgir.backend.math.FiniteDifferenceCounter;
import com.maksgir.backend.method.LagrangeMethod;
import com.maksgir.backend.method.NewtonMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MathService {

    @Autowired
    private FiniteDifferenceCounter differenceCounter;

    @Autowired
    private NewtonMethod newtonMethod;

    @Autowired
    private LagrangeMethod lagrangeMethod;

    public Answer solve(List<Point> pointList) {
        Answer answer = new Answer();
        double[] xs = new double[pointList.size()];
        for (int i = 0; i < pointList.size(); i++) {
            xs[i] = pointList.get(i).getX();
        }

        answer.setFiniteDifference(differenceCounter.count(pointList));
        answer.setN(pointList.size());

        answer.setNewton(newtonMethod.countCoef(pointList));
        answer.setCLang(lagrangeMethod.solve(pointList));

        return answer;
    }

}
