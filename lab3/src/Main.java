import console.ConsoleWorker;
import dto.InputData;
import integral.IntegralAbstract;
import methods.Method;

public class Main {
    public static void main(String[] args) {
        ConsoleWorker cWorker = new ConsoleWorker();

        IntegralAbstract integral = cWorker.readIntegral();
        InputData data = cWorker.readInputData();
        Method method = cWorker
    }
}
