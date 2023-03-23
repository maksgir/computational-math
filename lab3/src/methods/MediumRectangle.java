package methods;

import dto.Answer;
import integral.Integral;

public class MediumRectangle extends RectangleAbstract{
    @Override
    public Answer solve(Integral integral) {
        return rectangleSolution(integral,
                (a, i, h) -> (a + (i + 0.5) * h));
    }
}
