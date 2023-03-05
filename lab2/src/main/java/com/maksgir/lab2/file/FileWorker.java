package com.maksgir.lab2.file;

import com.maksgir.lab2.dto.InputData;
import com.maksgir.lab2.exception.ParsingException;
import com.maksgir.lab2.exception.WrongFileDataFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWorker {

    private String filename;
    private Scanner in = new Scanner(System.in);
    private double a;
    private double b;
    private double e;


    public FileWorker() {
        readFilename();
    }


    public InputData readInputData() throws Exception {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            readInterval(reader);
            readE(reader);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return new InputData(a, b, e);
    }

    private void readFilename() {
        String path;
        do {
            System.out.println("Введите путь до файла начиная с scr");
            path = in.nextLine();

        } while (!(Files.exists(Path.of(path))));

        filename = path;
    }

    private void readInterval(BufferedReader reader) throws IOException, WrongFileDataFormat, ParsingException {

        String line = reader.readLine();
        String[] splitted = line.split(" ");
        if (splitted.length != 2) {
            throw new WrongFileDataFormat("Невалидная строка: " + line + "\n ожидалось 2 числа - , given - " + splitted.length);
        }
        try {
            a = Double.parseDouble(splitted[0]);
            b = Double.parseDouble(splitted[1]);
        } catch (Exception e) {
            throw new ParsingException();
        }


    }

    private void readE(BufferedReader reader) throws IOException, WrongFileDataFormat {
        String line = reader.readLine();
        e = Float.parseFloat(line);

        if (e <= 0) {
            throw new WrongFileDataFormat("E should be > 0");
        }
    }

}
