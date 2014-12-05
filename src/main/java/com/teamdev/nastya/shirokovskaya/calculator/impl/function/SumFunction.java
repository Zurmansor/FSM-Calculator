package com.teamdev.nastya.shirokovskaya.calculator.impl.function;


public class SumFunction extends  AbstractFunction{
    /**
     * Considers the sum of input values.
     * @param args
     * @return the sum of input values
     */
    @Override
    public double perform(Double... args) {
        double result = 0;
        for (Double arg : args) {
            result += arg;
        }
        return result;
    }
}