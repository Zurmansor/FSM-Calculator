package com.teamdev.nastya.shirokovskaya.core.impl.function;

import com.google.common.base.Preconditions;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

public class SqrtFunction extends AbstractFunction{
    /**
     * Considers the cube root of a value.
     * @param args
     * @return the cube root of input parameter.
     * @throws IllegalStateException, IllegalArgumentException
     */
    @Override
    public double perform(Double... args) throws IllegalStateException, IllegalArgumentException {
        Preconditions.checkState(args.length == 1, "To many parameters for function sqrt");
        Preconditions.checkArgument(args[0] >= 0, "sqrt argument can`t be negative");
        return Math.sqrt(args[0]);
    }
}