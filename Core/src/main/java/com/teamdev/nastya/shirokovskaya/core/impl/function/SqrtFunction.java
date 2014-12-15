package com.teamdev.nastya.shirokovskaya.core.impl.function;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

public class SqrtFunction extends  AbstractFunction{
    /**
     * Considers the cube root of a value.
     * @param args
     * @return the cube root of input parameter.
     * @throws EvaluationException
     */
    @Override
    public double perform(Double... args) throws EvaluationException {
        if (args.length > 1) {
//            return Double.NaN;
//            TODO: определить index
            throw new EvaluationException("To many parameters for function sqrt", 1);
        }
        return Math.sqrt(args[0]);
    }
}