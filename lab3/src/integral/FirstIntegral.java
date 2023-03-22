package integral;

public class FirstIntegral extends IntegralAbstract {
    public static String fName = "4x^3 + -5x^2 + 6x - 7";

    @Override
    public Double func(Double x) {
        return 4 * x * x * x - 5 * x * x + 6 * x - 7;
    }
}
