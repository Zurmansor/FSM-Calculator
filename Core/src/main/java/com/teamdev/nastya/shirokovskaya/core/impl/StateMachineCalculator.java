package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.MathExpressionCalculator;
import com.teamdev.nastya.shirokovskaya.fsm.FiniteStateMachine;

import java.util.HashMap;


public class StateMachineCalculator extends FiniteStateMachine<
        State, EvaluationContext, HashMap<String, Double>, EvaluationException>
        implements MathExpressionCalculator {

    @Override
    public HashMap<String, Double> evaluate(String mathExpression) throws EvaluationException {
        return run(new EvaluationContext(mathExpression));
    }

    @Override
    protected void deadlock(EvaluationContext context, State currentState) throws EvaluationException {
        throw new EvaluationException("Incorrect expression format",
                context.getExpressionReader().getIndex());
    }

    @Override
    protected HashMap<String, Double> finish(EvaluationContext context) {
//        double evaluationResult = context.getEvaluationStack().getOperandStack().pop();
        return context.getEvaluationStack().getVariableMap();
    }
}
