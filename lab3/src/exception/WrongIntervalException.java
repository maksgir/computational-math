package exception;

public class WrongIntervalException extends Exception {
    public WrongIntervalException(double x) {
        super("Функция не существует в точке " + x + "\nВыберите другой интервал");
    }
}
