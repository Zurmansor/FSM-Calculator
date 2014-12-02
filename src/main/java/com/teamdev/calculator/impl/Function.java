package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;

public interface Function {

    double perform(Double... args) throws EvaluationException;
}