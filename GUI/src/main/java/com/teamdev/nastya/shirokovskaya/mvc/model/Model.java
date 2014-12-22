package com.teamdev.nastya.shirokovskaya.mvc.model;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;

import java.util.HashMap;

public class Model {

    public HashMap<String, Double> calcExpression(String mathExpression) throws EvaluationException {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        return calculator.evaluate(mathExpression);
    }
}
