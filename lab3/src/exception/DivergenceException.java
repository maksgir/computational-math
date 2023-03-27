package exception;

public class DivergenceException extends Exception {

    public DivergenceException(double point) {
        super("Интеграл нескодящийся, точка разрыва: " + point);
    }


}
