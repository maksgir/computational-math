package com.maksgir.lab2.data;

import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.equation.Equation;

public class SelfWorker implements DataWorker {
    private Equation equation;


    public SelfWorker(Equation equation) {
        this.equation = equation;
    }

    @Override
    public BigInterval readInterval() {
        return new BigInterval(-10, 10);
    }
}
