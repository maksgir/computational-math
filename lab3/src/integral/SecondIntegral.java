package integral;

public class SecondIntegral extends Integral {
    public static String fName = "sin(2x)^2 / 7";

    @Override
    public Double func(Double x) {
        return Math.pow(Math.sin(2 * x), 2) / 7;
    }
}
