package com.teamdev.calculator.impl.function;


public class SumFunction extends  AbstractFunction{
    @Override
    public double perform(Double... args) {
        double result = 0;
        for (Double arg : args) {
            result += arg;
        }
        return result;
    }
}