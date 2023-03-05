package com.maksgir.lab2.math;

import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.AnswerSystem;
import com.maksgir.lab2.dto.BigInterval;
import com.maksgir.lab2.system.SystemTask;

public interface SystemSolutionMethod {
    AnswerSystem proceed(BigInterval interval, SystemTask system);
}
