package com.math;

import com.dto.Answer;
import com.dto.InputData;

import java.util.Arrays;

public class Counter {

    private float[][] matrix;
    private int n;
    private float epsilon;
    private float[][] cMatrix;
    private float[] dMatrix;

    private Answer answer;

    public Counter(InputData data) {

        this.matrix = data.getMatrix();
        this.n = data.getN();
        this.epsilon = data.getE();
        this.cMatrix = new float[n][n];
        this.dMatrix = new float[n];


    }

    public Answer countDecision() {

        countSupportingMatrix();

        answer = new Answer(n);
        answer.setLastLine(dMatrix);
        answer.setIteration(0);

        do {
            answer.incrementIteration();
            countVariable(answer.getIteration());
        } while (answer.getAccuracy() > epsilon);

        return answer;
    }

    private void countSupportingMatrix() {
        for (int i = 0; i < n; i++) {
            cMatrix[i][i] = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    cMatrix[i][j] = (-1) * matrix[i][j] / matrix[i][i];
                }
            }

            dMatrix[i] = matrix[i][n] / matrix[i][i];
        }

    }

    private void countVariable(int iteration) {
        System.out.println("Iteration - " + iteration);
        float[] previous = answer.getLastLine();
        float[] currentLine = new float[n];

        for (int i = 0; i < n; i++) {
            float sum = dMatrix[i];

            for (int j = 0; j < n; j++) {
                sum += cMatrix[i][j] * previous[j];
            }
            currentLine[i] = sum;
        }

        System.out.println(Arrays.toString(currentLine));

        float currentAccuracy = 0;
        for (int i = 0; i < n; i++) {
            float c = Math.abs(currentLine[i] - previous[i]);
            currentAccuracy = Math.max(c, currentAccuracy);
        }
        System.out.println("Accuracy - " + currentAccuracy);

        answer.setLastLine(currentLine);
        answer.setAccuracy(currentAccuracy);

        System.out.println("-----------------");
    }
}

