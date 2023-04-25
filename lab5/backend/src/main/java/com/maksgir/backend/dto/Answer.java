package com.maksgir.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Answer {
    private double[] newton;
    private double[] cLang;
    private double[][] finiteDifference;
    private int n;

}
