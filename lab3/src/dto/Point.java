package dto;

public class Point {
    private double x;

    public Point(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                '}';
    }
}
