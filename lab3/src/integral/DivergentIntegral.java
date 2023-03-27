package integral;

public class DivergentIntegral extends Integral {

    public static String fName = "1/x";

    @Override
    public Double func(Double x) {
        return 1 / x;
    }

    @Override
    public double primordial(double x) {
        return Math.log(x);
    }
}
