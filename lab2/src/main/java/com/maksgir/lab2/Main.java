package com.maksgir.lab2;

import com.maksgir.lab2.console.Messages;
import com.maksgir.lab2.data.*;
import com.maksgir.lab2.dto.Answer;
import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.Equation;
import com.maksgir.lab2.equation.QuadraticEquation;
import com.maksgir.lab2.equation.ThirdDegreeEquation;
import com.maksgir.lab2.equation.TranscendentalEquation;
import com.maksgir.lab2.exception.NoSolutionFoundException;
import com.maksgir.lab2.math.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Стартуем");

        try {
            proceed();

        } catch (Exception e) {
            endWithException(e);
        }


    }

    private static void proceed() {

        IntervalCounter iCounter = new IntervalCounter();

        Equation equation = chooseEquation();


        DataWorker dataWorker = chooseDataWorker(equation);

        Interval interval;

        do {

            BigInterval bigInterval = dataWorker.readInterval();

            List<Interval> intervals = iCounter.countIntervals(equation, bigInterval);

            try {
                interval = chooseInterval(intervals);
                System.out.println(interval);
            } catch (NoSolutionFoundException e) {
                System.out.println(e.getMessage());
                Messages.tryAgainMessage();
                continue;
            }

            break;

        } while (true);

        double epsilon = chooseEpsilon();

        SolutionMethod method = chooseMethod();

        Answer answer = method.solveEquation(equation, interval, epsilon);

        System.out.println(answer);



    }


    private static Equation chooseEquation() {

        String answer;
        do {
            Messages.chooseEquationMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        return switch (answer) {
            case "2" -> new QuadraticEquation();
            case "3" -> new TranscendentalEquation();
            default -> new ThirdDegreeEquation();
        };
    }

    private static SolutionMethod chooseMethod() {
        String answer;
        do {
            Messages.chooseEquationMethodMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        return switch (answer) {
            case "1" -> new HalfDivisionMethod();
            case "2" -> new SecantMethod();
            default -> new SimpleIterationMethod();
        };
    }

    private static DataWorker chooseDataWorker(Equation equation) {

        String answer;
        do {
            Messages.chooseDataWorkerMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1") ? new UserInputWorker() : new SelfWorker(equation);


    }

    private static Interval chooseInterval(List<Interval> intervals) throws NoSolutionFoundException {

        if (intervals.isEmpty()) {
            throw new NoSolutionFoundException();
        }

        if (intervals.size() == 1) {
            Messages.showOnlyInterval(intervals.get(0));
            return intervals.get(0);
        }

        Integer n = null;
        do {
            Messages.showIntervals(intervals);
            String line = in.nextLine();
            try {

                n = Integer.parseInt(line);
                if (n > intervals.size() || n < 1) {
                    System.out.println("Наверное вы промахнулись");
                    Messages.tryAgainMessage();
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("Хочу число");
                Messages.tryAgainMessage();
            }
        } while (n == null);

        return intervals.get(n - 1);

    }

    private static Double chooseEpsilon() {
        String answer;
        do {
            Messages.chooseEpsilonMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        if (answer.equals("2")) {
            return 0.01;
        }

        Double n = null;
        do {
            Messages.chooseYourEpsilonMessage();
            String line = in.nextLine();
            try {

                n = Double.parseDouble(line);
                if (n <= 0 || n > 1) {
                    System.out.println("Повнимательнее с ограничениями");
                    Messages.tryAgainMessage();
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("Хочу число");
                Messages.tryAgainMessage();
            }
        } while (n == null);

        return n;
    }

    private static void endWithException(Exception e) {
        System.out.println("Больше так не делайте : " + e.getMessage());
    }
}
