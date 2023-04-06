package math;

import dto.Point;
import dto.InputData;
import exception.DivergenceException;
import exception.WrongIntervalException;
import integral.Integral;

import java.util.ArrayList;
import java.util.List;

public class GapScanner {

    private Integral integral;

    private final double step = 0.01;

    public GapScanner(Integral integral) {
        this.integral = integral;
    }

    public List<Point> scanPoints() throws DivergenceException, WrongIntervalException {
        List<Point> points = new ArrayList<>();

        InputData data = integral.getData();

        double a = data.getA();
        double b = data.getB();
        double scale = Math.pow(10, 2);

        for (double current = a; current <= b; current += step) {

            current = Math.ceil(current * scale) / scale;
            double y = integral.func(current);
            if (Double.isNaN(y)) {
                throw new WrongIntervalException(current);
            }

            if (current == a) {

                if (isInfinity(y)) {
                    checkConvergence(current);
                    points.add(new Point(a + step));
                } else {
                    points.add(new Point(a));
                }

            } else if (current == b) {

                if (isInfinity(y)) {
                    checkConvergence(current);
                    points.add(new Point(b - step));
                } else {
                    points.add(new Point(b));
                }

            } else if (isInfinity(y)) {
                checkConvergence(current);
                points.add(new Point(current - step));
                points.add(new Point(current + step));
            }
        }

        return points;
    }

    private boolean isInfinity(double y) {
        return y == Double.POSITIVE_INFINITY || y == Double.NEGATIVE_INFINITY;
    }


    private void checkConvergence(double x) throws DivergenceException {

        double y = integral.primordial(x);

        if (isInfinity(y)) {
            throw new DivergenceException(x);
        }

    }
}
