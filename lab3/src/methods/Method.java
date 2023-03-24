package methods;

import dto.Answer;
import dto.InputData;
import integral.Integral;
import util.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class Method {
    protected int defaultN = 4;

    public abstract Answer solve(Integral integral);

    protected Answer commonSolution(Integral integral,
                                    TriFunction<Double, Integer, Double, Double> functionForX,
                                    Function<Integer, Integer> rangeForX,
                                    Function<Integer, Integer> rangeForY,
                                    BiFunction<double[], Integer, Double> functionForS,
                                    BiFunction<Double, Double, Double> functionForAns,
                                    int k) {

        InputData data = integral.getData();
        int n = defaultN;
        double h;
        double previous = 0;
        double current;


        while (true) {
            h = (data.getB() - data.getA()) / n;
            double[] y = new double[rangeForY.apply(n)];

            for (int i = 0; i < rangeForX.apply(n); i++) {
                double x = functionForX.apply(data.getA(), i, h);
                y[i] = integral.func(x);
            }
            current = functionForS.apply(y, n);
            if (countAccuracy(previous, current, k, data.getE())) {
                break;
            }
            previous = current;
            n *= 2;
        }

        double ans = functionForAns.apply(h, current);

        return new Answer(ans, n);
    }

    protected boolean countAccuracy(double I0, double I1, int k, double epsilon) {
        return ((I0 - I1) / (Math.pow(2, k) - 1)) <= epsilon;
    }
}
