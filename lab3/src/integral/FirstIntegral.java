package integral;

public class FirstIntegral extends IntegralAbstract {


    public FirstIntegral(double a, double b, int n) {
        super(a, b, n);
    }

    @Override
    public Double func(Double x) {
        return 4 * x * x * x - 5 * x * x + 6 * x - 7;
    }
}
