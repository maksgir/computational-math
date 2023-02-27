package com;


import com.console.ConsoleWorker;
import com.dto.Answer;
import com.dto.InputData;
import com.file.FileWorker;
import com.generator.GenerateWorker;
import com.math.Counter;
import com.math.DiagonalWorker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Start");

        try {
            DataWorker dataWorker = getInfoInputWay();
            InputData data = dataWorker.readData();

            DiagonalWorker.makeMatrixDiagonalPredominant(data);

            Counter counter = new Counter(data);

            Answer answer = counter.countDecision();
            printAnswer(answer);

        } catch (Exception e) {
            endWithError(e);
        }

    }

    private static void printAnswer(Answer answer) {
//        answer.round();

        System.out.print("\nAnswer - ");
        System.out.println(Arrays.toString(answer.getLastLine()));
        System.out.println("Accuracy - " + answer.getAccuracy());
        System.out.println("Iteration produced - " + answer.getIteration());
    }

    private static DataWorker getInfoInputWay() {
        String answer;
        do {
            System.out.println("Do you wanna set your data or generate it?(m/g)");
            answer = in.nextLine();

        } while (!(answer.equals("m") || answer.equals("g")));

        if (answer.equals("g")) {
            return new GenerateWorker();
        }

        String answer2;
        do {
            System.out.println("Read matrix from FILE or CONSOLE (f/c)?");
            answer2 = in.nextLine();

        } while (!(answer2.equals("f") || answer2.equals("c")));

        if (answer2.equals("f")) {
            return new FileWorker(readFilename());
        }
        return new ConsoleWorker();

    }

    private static String readFilename() {
        String path;
        do {
            System.out.println("Enter file path");
            path = in.nextLine();

        } while (!(Files.exists(Path.of(path))));

        return path;
    }

    private static void endWithError(Exception e){
        System.out.println("Program ends with exception : "+e.getMessage());
    }
}
