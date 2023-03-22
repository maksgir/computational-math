package dto;

public class InputData {
    private double a;
    private double b;
    private int n;

    public InputData(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public int getN() {
        return n;
    }
}
