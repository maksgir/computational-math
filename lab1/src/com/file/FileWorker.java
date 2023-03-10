package com.file;

import com.DataWorker;
import com.dto.InputData;
import com.exception.WrongFileDataFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWorker implements DataWorker {
    private Integer n;
    private Float e;

    private float[][] matrix;
    private String filename;

    public FileWorker(String filename) {
        this.filename = filename;
        remind();
    }

    @Override
    public InputData readData() throws Exception {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            readN(reader);
            readMatrix(reader);
            readE(reader);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return new InputData(n, e, matrix);
    }

    private void readN(BufferedReader reader) throws IOException, WrongFileDataFormat {

        String line = reader.readLine();
        n = Integer.parseInt(line);
        if (n > 20){
            throw new WrongFileDataFormat("N should be <= 20");
        }
    }

    private void readE(BufferedReader reader) throws IOException, WrongFileDataFormat {
        String line = reader.readLine();
        e = Float.parseFloat(line);

        if (e <=0){
            throw new WrongFileDataFormat("E should be > 0");
        }
    }

    private void readMatrix(BufferedReader reader) throws Exception {

        matrix = new float[n][n + 1];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] splitted = line.split(" ");
            if (splitted.length != (n + 1)) {
                throw new WrongFileDataFormat("Wrong count of params in line: " + line + "\n expected - " + (n + 1) + ", given - " + splitted.length);
            }
            for (int j = 0; j < splitted.length; j++) {
                matrix[i][j] = Float.parseFloat(splitted[j]);
            }
        }


    }

    private void remind() {
        System.out.println("File structure should be:");
        System.out.println("---------------");
        System.out.println("n");
        System.out.println("a11 a12 ... a1n d1");
        System.out.println("a21 a22 ... a2n d2");
        System.out.println("... ... ... ... ..");
        System.out.println("an1 an2 ... ann dn");
        System.out.println("epsilon");
        System.out.println("---------------");
    }
}
