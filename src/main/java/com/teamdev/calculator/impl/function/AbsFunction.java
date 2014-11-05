package com.teamdev.calculator.impl.function;

import com.teamdev.calculator.EvaluationException;

public class AbsFunction extends  AbstractFunction{
    @Override
    public double perform(Double... args) throws EvaluationException {
        if (args.length > 1) {
//            return Double.NaN;
//            TODO: определить index
            throw new EvaluationException("To many parameters for function abs", 1);
        }
        return Math.abs(args[0]);
    }
}