package methods;

import dto.Answer;
import integral.Integral;

public class LeftRectangle extends RectangleAbstract {
    public static String name = "Метод левых прямоугольников";

    @Override
    public Answer solve(Integral integral) {

        return rectangleSolution(
                integral,
                (a, i, h) -> (a + i * h)
        );
    }
}
