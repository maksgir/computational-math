package com.math;

import com.dto.InputData;
import com.exception.DiagonalUnableException;


public class DiagonalWorker {

    public static void makeMatrixDiagonalPredominant(InputData data) throws DiagonalUnableException {
        if (checkIfMatrixIsDiagonal(data.getMatrix())) return;

        float[][] new_matrix = new float[data.getN()][];

        for (float[] line : data.getMatrix()) {
            float max_a = Float.MIN_VALUE;
            int max_i = 0;
            for (int i = 0; i < line.length - 1; i++) {
                if (Math.abs(line[i]) > max_a) {
                    max_a = line[i];
                    max_i = i;
                }

            }
            if (new_matrix[max_i] != null) {
                throw new DiagonalUnableException("Unable to convert matrix to diagonal");
            }

            new_matrix[max_i] = line;
        }


        if (checkIfMatrixIsDiagonal(new_matrix)) {
            data.setMatrix(new_matrix);

        } else {
            throw new DiagonalUnableException("Unable to convert matrix to diagonal");
        }

    }

    private static boolean checkIfMatrixIsDiagonal(float[][] matrix) {
        int numOfEquals = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            float diagElem = matrix[i][i];

            float sum = 0;

            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
            }
            sum -= Math.abs(diagElem);


            if (Math.abs(diagElem) < sum) {
                return false;
            } else if (Math.abs(diagElem) == sum) {
                numOfEquals++;
            }
        }

        return numOfEquals != n;
    }

}
