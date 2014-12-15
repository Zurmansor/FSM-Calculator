package com.teamdev.nastya.shirokovskaya.core.impl.function;


public class MaxFunction extends  AbstractFunction{
    /**
     * Considers the greater of two values.
     * @param args
     * @return maximum of input parameters.
     */
    @Override
    public double perform(Double... args) {
        double result = Double.MIN_VALUE;
        for (double arg : args) {
            result = Math.max(result, arg);
        }
        return result;
    }
}