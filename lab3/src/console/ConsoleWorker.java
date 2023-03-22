package console;

import dto.InputData;
import integral.FirstIntegral;
import integral.IntegralAbstract;
import integral.SecondIntegral;
import integral.ThirdIntegral;


import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleWorker {
    private Scanner in = new Scanner(System.in);

    public IntegralAbstract readIntegral() {
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

        int n = (int) readNumber(
                Messages::inputN,
                x -> (x > 2),
                Messages::inputError);

        return new InputData(a, b, n);


    }

    public IntegralAbstract readMethod() {
        String answer;
        do {
            Messages.chooseIntegral();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        if ()
        return switch (answer) {
            case "2" -> new FirstIntegral();
            case "3" -> new SecondIntegral();
            default -> new ThirdIntegral();
        };
    }

    private double readNumber(Runnable defaultMessage, Predicate<Double> predicate, Runnable errorMessage) {

        Double n = null;
        do {
            defaultMessage.run();
            String line = in.nextLine();
            try {

                n = Double.parseDouble(line);
                if (n <= 0 || n > 1) {
                    errorMessage.run();
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("А теперь давайте число...");
                errorMessage.run();
            }
        } while (n == null);

        return n;
    }


}
