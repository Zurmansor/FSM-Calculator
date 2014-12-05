package com.teamdev.nastya.shirokovskaya.calculator.impl.function;


public class MinFunction extends  AbstractFunction{
    /**
     * Considers the smaller of two values.
     * @param args
     * @return minimum of input parameters.
     */
    @Override
    public double perform(Double... args) {
        double result = Double.MAX_VALUE;
        for (double arg : args) {
            result = Math.min(result, arg);
        }
        return result;
    }

}