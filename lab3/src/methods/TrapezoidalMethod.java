package methods;

import dto.Answer;
import dto.InputData;
import integral.Integral;

import java.util.Arrays;

public class TrapezoidalMethod extends Method {
    public static String name = "Метод трапеций";

    protected int k = 2;

    @Override
    public Answer solve(Integral integral) {

        return commonSolution(
                integral,
                (a, i, h) -> (a + i * h),
                n -> n + 1,
                n -> n + 1,
                (y, n) -> (y[0] + y[n]) / 2 + Arrays.stream(Arrays.copyOfRange(y, 1, n - 1)).sum(),
                (h, s) -> h * s,
                k);
    }
}
