package com.maksgir.lab2.exception;

public class NoSolutionFoundException extends Exception {
    public NoSolutionFoundException() {
        super("Не смог найти корней на этом интервале");
    }
}
