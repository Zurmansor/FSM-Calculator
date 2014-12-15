package com.teamdev.nastya.shirokovskaya.mvc.model;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;

public class Model {

    public double calcExpression(String mathExpression) throws EvaluationException {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        return calculator.start(mathExpression);
    }
}
