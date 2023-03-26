package console;

import dto.InputData;
import integral.FirstIntegral;
import integral.Integral;
import integral.SecondIntegral;
import integral.ThirdIntegral;
import methods.*;


import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleWorker {
    private Scanner in = new Scanner(System.in);

    public Integral readIntegral() {
        String answer;
        do {
            Messages.chooseIntegral();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        return switch (answer) {
            case "2" -> new SecondIntegral();
            case "3" -> new ThirdIntegral();
            default -> new FirstIntegral();
        };
    }

    public InputData readInputData() {
        double a = readNumber(
                Messages::inputA,
                x -> (x >= -100) && (x <= 100),
                Messages::inputError);
        double b = readNumber(
                Messages::inputB,
                x -> (x >= -100) && (x <= 100) && (Math.abs(x - a) <= 10) && (x > a),
                Messages::inputError);

        double e = readNumber(
                Messages::inputE,
                x -> (x > 0) && (x < 1),
                Messages::inputError);

        return new InputData(a, b, e);


    }

    public Method readMethod() {
        String answer;
        do {
            Messages.chooseMethod();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        if (answer.equals("1")) {
            return readRectangleMethod();
        }
        if (answer.equals("2")) {
            return new TrapezoidalMethod();
        }
        return new SimpsonMethod();
    }

    public RectangleAbstract readRectangleMethod() {
        String answer;
        do {
            Messages.chooseRectangleMethod();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        return switch (answer) {
            case "2" -> new MediumRectangle();
            case "3" -> new RightRectangle();
            default -> new LeftRectangle();
        };
    }

    private double readNumber(Runnable defaultMessage, Predicate<Double> predicate, Runnable errorMessage) {

        Double n = null;
        do {
            defaultMessage.run();
            String line = in.nextLine();
            try {

                n = Double.parseDouble(line);
                if (!predicate.test(n)) {
                    errorMessage.run();
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("А теперь давайте число");
                errorMessage.run();
            }
        } while (n == null);

        return n;
    }


}
