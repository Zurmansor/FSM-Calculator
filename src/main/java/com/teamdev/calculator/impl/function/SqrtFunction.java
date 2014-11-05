package com.teamdev.calculator.impl.function;

import com.teamdev.calculator.EvaluationException;

public class SqrtFunction extends  AbstractFunction{
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