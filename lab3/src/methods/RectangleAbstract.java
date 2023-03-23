package methods;

import dto.Answer;
import dto.InputData;
import integral.Integral;
import util.TriFunction;

public abstract class RectangleAbstract extends Method {
    protected int k = 2;

    protected Answer rectangleSolution(Integral integral, TriFunction<Double, Integer, Double, Double> functionForX) {
        InputData data = integral.getData();
        int n = defaultN;
        double previous = 0;
        double current;

        while (true) {
            double h = (data.getB() - data.getA()) / n;
            current = 0;
            for (int i = 0; i < n; i++) {
                double x = functionForX.apply(data.getA(), i, h);
                current += integral.func(x);
            }
            if (countAccuracy(previous, current, k, data.getE())) {
                break;
            }
            previous = current;
            n *= 2;
        }

        return new Answer(current, n);
    }

}
