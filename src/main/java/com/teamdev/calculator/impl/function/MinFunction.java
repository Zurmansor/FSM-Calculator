package com.teamdev.calculator.impl.function;


public class MinFunction extends  AbstractFunction{
    @Override
    public double perform(Double... args) {
        double result = Double.MAX_VALUE;
        for (double arg : args) {
            result = Math.min(result, arg);
        }
        return result;
    }

}