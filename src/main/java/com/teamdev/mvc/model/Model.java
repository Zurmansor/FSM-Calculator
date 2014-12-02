package com.teamdev.mvc.model;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.StateMachineCalculator;

public class Model {

    public double calcExpression(String mathExpression) throws EvaluationException {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        return calculator.start(mathExpression);
    }
}
