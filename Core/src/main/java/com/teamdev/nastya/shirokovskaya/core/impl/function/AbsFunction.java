package com.teamdev.nastya.shirokovskaya.core.impl.function;

import com.google.common.base.Preconditions;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

public class AbsFunction extends  AbstractFunction{
    /**
     * Receiving module input parameters.
     * If the argument is not negative, the argument is returned.
     * If the argument is negative, the negation of the argument is returned.
     * @param args
     * @return the absolute value of a double value
     * @throws IllegalStateException if more then one argument
     */
    @Override
    public double perform(Double... args) throws IllegalStateException{
        Preconditions.checkState(args.length == 1, "To many parameters for function abs");
        return Math.abs(args[0]);
    }
}