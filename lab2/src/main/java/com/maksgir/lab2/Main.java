package com.maksgir.lab2;

import com.maksgir.lab2.console.ConsoleWorker;
import com.maksgir.lab2.console.Messages;
import com.maksgir.lab2.data.*;
import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.AnswerSystem;
import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.dto.InputData;
import com.maksgir.lab2.equation.*;
import com.maksgir.lab2.exception.NoSolutionFoundException;
import com.maksgir.lab2.file.FileWorker;
import com.maksgir.lab2.graphic.GraphicWorker;
import com.maksgir.lab2.math.*;
import com.maksgir.lab2.system.SystemTask;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Стартуем");

        try {
            proceed();

        } catch (Exception e) {
            ConsoleWorker.endWithException(e);
        }


    }

    private static void proceed() throws Exception {

        if (ConsoleWorker.isEquation()) {
            Equation equation = ConsoleWorker.chooseEquation();
            proceedEquation(equation);
        } else {
            SystemTask system = ConsoleWorker.chooseSystem();
            proceedSystem(system);
        }

    }

    private static void proceedEquation(Equation equation) throws Exception {

        IntervalCounter iCounter = new IntervalCounter();


        InputData data = null;

        if (ConsoleWorker.inputDataWayIsConsole()) {
            DataWorker dataWorker = ConsoleWorker.chooseDataWorker(equation);
            do {
                BigInterval bigInterval = dataWorker.readInterval();
                List<InputData> intervals = iCounter.countIntervals(equation, bigInterval);
                try {
                    data = ConsoleWorker.chooseInterval(intervals);
                    System.out.println(data);
                } catch (NoSolutionFoundException e) {
                    System.out.println(e.getMessage());
                    Messages.tryAgainMessage();
                    continue;
                }
                break;
            } while (true);
            double epsilon = ConsoleWorker.chooseEpsilon();
            data.setEpsilon(epsilon);
        } else {
            FileWorker fileWorker = new FileWorker();
            data = fileWorker.readInputData();
        }

        EquationSolutionMethod method = ConsoleWorker.chooseMethod();

        AnswerEquation answer = method.solveEquation(equation, data);

        System.out.println(answer);

        GraphicWorker.showEquation(answer);
    }

    private static void proceedSystem(SystemTask system) {

        Messages.initialApproximationMessage();
        UserInputWorker dataWorker = new UserInputWorker();

        BigInterval interval = dataWorker.readInterval();

        SystemSolutionMethod solutionMethod = new SimpleIterationSystemMethod();

        AnswerSystem answer = solutionMethod.proceed(interval, system);

        System.out.println(answer);

        GraphicWorker.showSystem(answer);

    }


}
