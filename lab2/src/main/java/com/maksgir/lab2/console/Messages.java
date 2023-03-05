package com.maksgir.lab2.console;

import com.maksgir.lab2.dto.Interval;
import com.maksgir.lab2.equation.QuadraticEquation;
import com.maksgir.lab2.equation.ThirdDegreeEquation;
import com.maksgir.lab2.equation.TranscendentalEquation;
import com.maksgir.lab2.system.FirstSystem;
import com.maksgir.lab2.system.SecondSystem;

import java.util.List;

public class Messages {
    public static void chooseTaskMessage() {

        System.out.println("Что будем решать: ");
        System.out.println("\t1. Уравнение");
        System.out.println("\t2. Система");
    }

    public static void chooseEquationMessage() {

        System.out.println("Выберите уравнение: ");
        System.out.println("\t1. " + ThirdDegreeEquation.equation);
        System.out.println("\t2. " + QuadraticEquation.equation);
        System.out.println("\t3. " + TranscendentalEquation.equation);
    }

    public static void chooseSystemMessage() {

        System.out.println("Выберите уравнение: ");
        System.out.println("\t1. " + FirstSystem.system);
        System.out.println("\t2. " + SecondSystem.system);
    }

    public static void chooseEquationMethodMessage() {

        System.out.println("Выберите метод, которым будем его решать: ");
        System.out.println("\t1. Метод половинного деления");
        System.out.println("\t2. Метод секущих");
        System.out.println("\t3. Метод простой итерации");
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

    public static void showIntervalsMessage(List<Interval> intervals) {
        System.out.println("На указанном интервале нашлось несколько корней");
        System.out.println("Давайте выберем какой из них будем определять точно");
        int a = 1;
        for (Interval i : intervals) {
            System.out.println("\t" + a + ": " + i);
            a++;
        }
    }

    public static void showOnlyIntervalMessage(Interval interval) {
        System.out.println("На указанном интервале нашелся один корень: " + interval);
    }

    public static void initialApproximationMessage() {
        System.out.println("Нужно ввести начальное приближение : ");
    }

}
