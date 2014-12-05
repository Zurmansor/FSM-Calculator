package com.teamdev.nastya.shirokovskaya.mvc.model;

import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;
import com.teamdev.nastya.shirokovskaya.calculator.impl.StateMachineCalculator;

public class Model {

    public double calcExpression(String mathExpression) throws EvaluationException {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        return calculator.start(mathExpression);
    }
}
