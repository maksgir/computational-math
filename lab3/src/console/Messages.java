package console;

import integral.FirstIntegral;
import integral.SecondIntegral;
import integral.ThirdIntegral;

public class Messages {
    public static void chooseIntegral(){
        System.out.println("Выберите интеграл который будем решать:\n");
        System.out.println("\t"+ FirstIntegral.fName+"\n");
        System.out.println("\t"+ SecondIntegral.fName+"\n");
        System.out.println("\t"+ ThirdIntegral.fName+"\n");
    }

    public static void inputA(){
        System.out.println("Введите левый промежуток (-100 <= a <= 100)");
    }

    public static void inputB(){
        System.out.println("Введите правый промежуток (разница с левым не больше 10)");
    }

    public static void inputN(){
        System.out.println("Введите количество разбиений интервала (больше 2)");
    }

    public static void inputError(){
        System.out.println("Обратите внимание на условия и попробуйте еще раз");
    }
}
