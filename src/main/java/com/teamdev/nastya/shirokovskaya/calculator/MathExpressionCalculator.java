package com.teamdev.nastya.shirokovskaya.calculator;

public interface MathExpressionCalculator {

    double evaluate(String mathExpression) throws EvaluationException;
}
