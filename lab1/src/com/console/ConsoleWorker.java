package com.console;

import com.DataWorker;
import com.dto.InputData;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleWorker implements DataWorker {
    private Integer n;
    private Float e;

    private float[][] matrix;

    private Scanner in = new Scanner(System.in);

    @Override
    public InputData readData() {

        readN();
        readE();
        readMatrix();

        return new InputData(n, e, matrix);
    }

    private void readN() {
        System.out.println("Enter N (<=20)");


        do {
            String line = in.nextLine();
            try {
                n = Integer.parseInt(line);
                if (n > 20) {
                    System.out.println("too big");
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("Enter int N correctly");
            }
        } while (n == null);

    }

    private void readE() {
        System.out.println("Enter E");
        do {
            String line = in.nextLine();
            try {
                e = Float.parseFloat(line);
            } catch (Exception e) {
                System.out.println("Enter float Epsilon correctly");
            }
        } while (e == null);

    }

    private void readMatrix() {
        matrix = new float[n][n + 1];

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            do {
                remind(i + 1, n);
                try {
                    String line = in.nextLine();

                    String[] splitted = line.split(" ");
                    if (splitted.length != (n + 1)) {
                        throw new Exception("Smth wrong with matrix");
                    }

                    for (int j = 0; j < splitted.length; j++) {
                        matrix[i][j] = Float.parseFloat(splitted[j]);
                    }
                    flag = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    ;
                }
            } while (!flag);

        }

        System.out.println("Считал матрицу");
        System.out.println(Arrays.deepToString(matrix));

    }

    private void remind(int i, int n) {
        System.out.println("Enter matrix line like :");
        System.out.println("A" + i + ":1 A" + i + ":2 ... A" + i + ":" + n + " d" + i);
    }
}
