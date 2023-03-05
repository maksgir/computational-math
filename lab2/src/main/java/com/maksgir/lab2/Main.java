package com.maksgir.lab2;

import com.maksgir.lab2.console.Messages;
import com.maksgir.lab2.data.*;
import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.AnswerSystem;
import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.*;
import com.maksgir.lab2.exception.NoSolutionFoundException;
import com.maksgir.lab2.math.*;
import com.maksgir.lab2.system.FirstSystem;
import com.maksgir.lab2.system.SecondSystem;
import com.maksgir.lab2.system.SystemTask;
import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Стартуем");

        show();
        try {
            proceed();

        } catch (Exception e) {
            endWithException(e);
        }




    }

    private static void proceed() {

        if (isEquation()){
            Equation equation = chooseEquation();
            proceedEquation(equation);
        } else {
            SystemTask system = chooseSystem();
            proceedSystem(system);
        }

    }

    private static void proceedEquation(Equation equation) {

        IntervalCounter iCounter = new IntervalCounter();
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

        EquationSolutionMethod method = chooseMethod();

        AnswerEquation answer = method.solveEquation(equation, interval, epsilon);

        System.out.println(answer);
    }

    private static void proceedSystem(SystemTask system) {

        Messages.initialApproximationMessage();
        UserInputWorker dataWorker = new UserInputWorker();

        BigInterval interval = dataWorker.readInterval();

        SystemSolutionMethod solutionMethod = new SimpleIterationSystemMethod();

        AnswerSystem answer = solutionMethod.proceed(interval, system);

        System.out.println(answer);

    }

    private static boolean isEquation(){
        String answer;
        do {
            Messages.chooseTaskMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1");
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

    private static SystemTask chooseSystem(){
        String answer;
        do {
            Messages.chooseSystemMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1")? new FirstSystem(): new SecondSystem();
    }

    private static EquationSolutionMethod chooseMethod() {
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
            Messages.showOnlyIntervalMessage(intervals.get(0));
            return intervals.get(0);
        }

        Integer n = null;
        do {
            Messages.showIntervalsMessage(intervals);
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

    private static void show(){
        double[] x = {0, 5, 7};
        double[] y = {0, 3, 5};

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        // add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y);

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setSize(800, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}
