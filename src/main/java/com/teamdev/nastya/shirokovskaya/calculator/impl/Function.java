package com.teamdev.nastya.shirokovskaya.calculator.impl;

import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;

public interface Function {

    double perform(Double... args) throws EvaluationException;
}