package com.maksgir.backend.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point {
    private double x;
    private double y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
