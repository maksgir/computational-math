package com.generator;

import com.DataWorker;
import com.dto.InputData;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Scanner;

public class GenerateWorker implements DataWorker {

    private Integer n;
    private Float e;

    private float[][] matrix;

    private Scanner in = new Scanner(System.in);



    @Override
    public InputData readData() {
        readN();
        readE();
        generateMatrix();


        return new InputData(n,e,matrix);
    }

    private void readN() {
        System.out.println("Enter N (<=20)");


        do {
            String line = in.nextLine();
            try {

                n = Integer.parseInt(line);
                if (n > 20 || n<=1) {
                    System.out.println("N should be <= 20 and > 1");
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

            try {
                String line = in.nextLine();
                e = Float.parseFloat(line);
                if (e <= 0) {
                    System.out.println("E should be > 0");
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("Enter float Epsilon correctly");
            }
        } while (e == null);

    }

    private void generateMatrix() {
        this.matrix = new float[n][n + 1];
        int maxik;


        for (int i = 0; i < n; i++) {
            do {
                maxik = (int) (Math.random() * n*10);
            } while (maxik < n*8);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * ((maxik * 2)/n - 1)) - ((maxik/n) - 1);
            }
            matrix[i][i] = maxik;
            matrix[i][n] = (int) (Math.random() * (200 - 1)) - (100);
        }

    }
}
