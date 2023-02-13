package com.dto;

public class Answer {
    private float[] lastLine;

    private float accuracy;

    private int iteration;

    public Answer(int n) {
        this.lastLine = new float[n];
    }

    public void round() {
        for (int i = 0; i < lastLine.length; i++) {
            lastLine[i] = Math.round(lastLine[i]);
        }
    }

    public float[] getLastLine() {
        return lastLine;
    }

    public void setLastLine(float[] lastLine) {
        this.lastLine = lastLine;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public void incrementIteration() {
        iteration++;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }
}
