package integral;


public class ThirdIntegral extends Integral {

    public static String fName = "-x^3 - x^2 + x + 3";

    @Override
    public Double func(Double x) {
        return -Math.pow(x, 3) - x * x + x + 3;
    }

    @Override
    public double primordial(double x) {
        return 1;
    }
}
