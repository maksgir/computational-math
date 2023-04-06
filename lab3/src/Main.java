import console.ConsoleWorker;
import console.Messages;
import dto.Answer;
import dto.Point;
import dto.InputData;
import exception.DivergenceException;
import exception.WrongIntervalException;
import integral.Integral;
import math.GapScanner;
import methods.Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            proceed();
        } catch (Exception e) {
            endWithException(e);
        }
    }

    private static void proceed() throws DivergenceException, WrongIntervalException {
        ConsoleWorker cWorker = new ConsoleWorker();
        Integral integral = cWorker.readIntegral();

        InputData data = cWorker.readInputData();
        integral.setData(data);

        Method method = cWorker.readMethod();
        GapScanner gapScanner = new GapScanner(integral);

        List<Point> points = gapScanner.scanPoints();

        if (points.size() == 2) {
            InputData dataForIntegral = new InputData(points.get(0).getX(), points.get(1).getX(), data.getE());
            integral.setData(dataForIntegral);
            Answer answer = method.solve(integral);
            endWithSimpleAnswer(answer);
        } else {
            double sum = 0;
            for (int i = 1; i < Objects.requireNonNull(points).size(); i++) {
                InputData dataForIntegral = new InputData(points.get(i - 1).getX(), points.get(i).getX(), data.getE());
                integral.setData(dataForIntegral);
                sum += method.solve(integral).getAnswer();
            }

            endWithConvergentAnswer(sum);

        }

    }


    private static void endWithException(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void endWithSimpleAnswer(Answer answer) {
        Messages.showAnswer(answer);
    }

    private static void endWithConvergentAnswer(double sum) {
        Messages.showConvergentAnswer(sum);
    }


}
