package integral;

public class ConvergentIntegral extends Integral {

    public static String fName = "1/sqrt(x)";

    @Override
    public double primordial(double x) {
        return 2 * Math.sqrt(x);
    }

    @Override
    public Double func(Double x) {
        return 1 / Math.sqrt(x);
    }
}
