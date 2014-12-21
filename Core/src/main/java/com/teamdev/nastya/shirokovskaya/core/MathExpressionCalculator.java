package com.teamdev.nastya.shirokovskaya.core;

import java.util.HashMap;

public interface MathExpressionCalculator {

    HashMap<String, Double> evaluate(String mathExpression) throws EvaluationException;
}
