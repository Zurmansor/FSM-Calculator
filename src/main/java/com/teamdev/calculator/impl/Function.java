package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;

public interface Function {
//    Integer minParams = -1;
//    Integer maxParams = -1;

    double perform(Double... args) throws EvaluationException;
}