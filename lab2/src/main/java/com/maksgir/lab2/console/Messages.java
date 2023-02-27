package com.maksgir.lab2.console;

import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.QuadraticEquation;
import com.maksgir.lab2.equation.ThirdDegreeEquation;
import com.maksgir.lab2.equation.TranscendentalEquation;
import com.maksgir.lab2.enums.Method;

import java.util.List;

public class Messages {
    public static void chooseEquationMessage() {

        System.out.println("Выберите уравнение: ");
        System.out.println("\t1. " + ThirdDegreeEquation.equation);
        System.out.println("\t2. " + QuadraticEquation.equation);
        System.out.println("\t3. " + TranscendentalEquation.equation);
    }

    public static void chooseEquationMethodMessage() {

        System.out.println("Выберите метод, которым будем его решать: ");
        System.out.println("\t1. " + Method.HALF_DIVISION);
        System.out.println("\t2. " + Method.SECANT);
        System.out.println("\t3. " + Method.SIMPLE_ITERATION);
    }

    public static void chooseEpsilonMessage() {
        System.out.println("Хотите свою погрешность (1) или по умолчанию - 0.01 (2)?");
    }

    public static void chooseYourEpsilonMessage() {
        System.out.println("Введите погрешность (Больше 0, меньше 1)?");
    }

    public static void chooseDataWorkerMessage() {

        System.out.println("Надо решить с интервалом, где мне искать корни.");
        System.out.println("Вы сами укажете (1) или мне самому поискать (2)?");
    }

    public static void inputLeftIntervalMessage() {
        System.out.println("Введите левый интервал");
    }

    public static void inputRightIntervalMessage() {
        System.out.println("Введите правый интервал (то что он больше левого это же очев?)");
    }

    public static void tryAgainMessage() {
        System.out.println("Попробуем еще раз");
        System.out.println("---------------------------");
    }

    public static void showIntervals(List<Interval> intervals) {
        System.out.println("На указанном интервале нашлось несколько корней");
        System.out.println("Давайте выберем какой из них будем определять точно");
        int a = 1;
        for (Interval i : intervals) {
            System.out.println("\t" + a + ": " + i);
            a++;
        }
    }

    public static void showOnlyInterval(Interval interval) {
        System.out.println("На указанном интервале нашелся один корень: " + interval);
    }

}
