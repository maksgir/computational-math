package com.dto;

public class Data {
    private Integer n;
    private Float e;

    private float[][] matrix;

    public Data(Integer n, Float e, float[][] matrix) {
        this.n = n;
        this.e = e;
        this.matrix = matrix;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Float getE() {
        return e;
    }

    public void setE(Float e) {
        this.e = e;
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(float[][] matrix) {
        this.matrix = matrix;
    }
}
