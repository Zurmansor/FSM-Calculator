package com.teamdev.calculator.impl.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinFunction extends  AbstractFunction{
    @Override
    public double perform(Double... args) {
        double result = Double.MAX_VALUE;
        for (double arg : args) {
            result = Math.min(result, arg);
        }
        return result;
    }

    /*
    @Override
    public double perform(double leftOperand, double rightOperand) {
        return Math.min(leftOperand, rightOperand);
    }
    */
}