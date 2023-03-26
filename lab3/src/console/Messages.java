package console;

import dto.Answer;
import integral.FirstIntegral;
import integral.SecondIntegral;
import integral.ThirdIntegral;
import methods.*;

public class Messages {
    public static void chooseIntegral() {
        System.out.println("Выберите интеграл, который будем решать:");
        System.out.println("\t1." + FirstIntegral.fName );
        System.out.println("\t2." + SecondIntegral.fName );
        System.out.println("\t3." + ThirdIntegral.fName );
    }

    public static void chooseMethod() {
        System.out.println("Выберите метод, которым будем решать интеграл:");
        System.out.println("\t1." + RectangleAbstract.name );
        System.out.println("\t2." + TrapezoidalMethod.name );
        System.out.println("\t3." + SimpsonMethod.name );
    }

    public static void chooseRectangleMethod() {
        System.out.println("Выберите метод, которым будем решать интеграл:");
        System.out.println("\t1." + LeftRectangle.name );
        System.out.println("\t2." + MediumRectangle.name );
        System.out.println("\t3." + RightRectangle.name );
    }

    public static void inputA() {
        System.out.println("Введите левый промежуток (-100 <= a <= 100)");
    }

    public static void inputB() {
        System.out.println("Введите правый промежуток (разница с левым не больше 10)");
    }

    public static void inputE() {
        System.out.println("Введите погрешность (больше 0, меньше 1)");
    }

    public static void inputError() {
        System.out.println("Обратите внимание на условия и попробуйте еще раз");
    }

    public static void showAnswer(Answer answer) {
        System.out.println("Ответ: " + answer.getAnswer() + " за " + answer.getN()+" итераций");
    }
}
