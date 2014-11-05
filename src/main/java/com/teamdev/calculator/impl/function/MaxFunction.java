package com.teamdev.calculator.impl.function;


public class MaxFunction extends  AbstractFunction{
    @Override
    public double perform(Double... args) {
        double result = Double.MIN_VALUE;
        for (double arg : args) {
            result = Math.max(result, arg);
        }
        return result;
    }
}