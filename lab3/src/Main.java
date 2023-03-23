import console.ConsoleWorker;
import dto.Answer;
import dto.InputData;
import integral.Integral;
import methods.Method;

public class Main {
    public static void main(String[] args) {
        ConsoleWorker cWorker = new ConsoleWorker();

        Integral integral = cWorker.readIntegral();
        InputData data = cWorker.readInputData();
        integral.setData(data);

        Method method = cWorker.readMethod();
        Answer answer = method.solve(integral);

    }
}
