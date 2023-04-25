package com.maksgir.backend.service;

import com.maksgir.backend.dto.Answer;
import com.maksgir.backend.dto.Point;
import com.maksgir.backend.math.FiniteDifferenceCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MathService {

    @Autowired
    private FiniteDifferenceCounter differenceCounter;

    public Answer solve(List<Point> pointList) {
        Answer answer = new Answer();
        answer.setFiniteDifference(differenceCounter.count(pointList));
        answer.setN(pointList.size());
        return answer;
    }

}
