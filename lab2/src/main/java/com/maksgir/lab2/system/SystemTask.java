package com.maksgir.lab2.system;

import java.util.List;
import java.util.function.BiFunction;

public interface SystemTask {
    public List<List<BiFunction<Double, Double, Double>>> getJe();
    public void setJe(List<List<BiFunction<Double, Double, Double>>> je);
}
