package methods;

import dto.Answer;
import integral.Integral;

public abstract class Method {
    protected int defaultN=4;

    public abstract Answer solve(Integral integral);

    protected boolean countAccuracy(double I0, double I1, int k, double epsilon) {
        return ((I0 - I1) / (Math.pow(2, k) - 1)) <= epsilon;
    }
}
