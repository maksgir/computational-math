package methods;

import dto.Answer;
import integral.Integral;


public class SimpsonMethod extends Method {
    public static String name = "Метод Симпсона";


    protected int k = 4;

    @Override
    public Answer solve(Integral integral) {

        return commonSolution(
                integral,
                (a, i, h) -> (a + i * h),
                n -> n + 1,
                n -> n + 1,
                (y, n) -> {
                    double even = 0;
                    for (int i = 1; i < y.length; i += 2) {
                        even += y[i];
                    }
                    double odd = 0;
                    for (int i = 2; i < y.length; i += 2) {
                        odd += y[i];
                    }

                    return y[0] + y[n] + 4 * even + 2 * odd;
                },
                (h, s) -> h * s / 3,
                k);
    }
}
