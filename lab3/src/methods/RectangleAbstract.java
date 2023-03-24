package methods;

import dto.Answer;
import dto.InputData;
import integral.Integral;
import util.TriFunction;

import java.util.Arrays;

public abstract class RectangleAbstract extends Method {
    protected int k = 2;

    protected Answer rectangleSolution(Integral integral, TriFunction<Double, Integer, Double, Double> functionForX) {
        return commonSolution(integral,
                functionForX,
                n -> n,
                n -> n,
                (y, n) -> (Arrays.stream(y).sum()),
                (h, s) -> h * s,
                k);
    }

}
