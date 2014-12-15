package com.teamdev.nastya.shirokovskaya.core.impl.function;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

public class AbsFunction extends  AbstractFunction{
    /**
     * Receiving module input parameters.
     * If the argument is not negative, the argument is returned.
     * If the argument is negative, the negation of the argument is returned.
     * @param args
     * @return the absolute value of a double value
     * @throws EvaluationException if more then one argument
     */
    @Override
    public double perform(Double... args) throws EvaluationException {
        if (args.length > 1) {
            throw new EvaluationException("To many parameters for function abs", 1);
        }
        return Math.abs(args[0]);
    }
}