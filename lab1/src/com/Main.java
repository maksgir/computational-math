package com;


import com.console.ConsoleWorker;
import com.dto.Data;
import com.file.FileWorker;
import com.math.Counter;
import com.math.DiagonalWorker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Start");
        DataWorker dataWorker = getInfoInputWay();

        try {
            Data data = dataWorker.readData();

            DiagonalWorker.makeMatrixDiagonalPredominant(data);

            Counter counter = new Counter(data);

            counter.countDecision();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static DataWorker getInfoInputWay() {
        String answer;
        do {
            System.out.println("Read matrix from FILE or CONSOLE (f/c)?");
            answer = in.nextLine();

        } while (!(answer.equals("f") || answer.equals("c")));

        if (answer.equals("f")) {
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
}
