package com.teamdev.calculator.impl;

import com.teamdev.fsm.StateAcceptor;
import com.teamdev.fsm.StateMachineContext;
import com.teamdev.fsm.TransitionMatrix;

public class EvaluationContext implements StateMachineContext<State, EvaluationContext> {

    private final EvaluationMatrix matrix = new EvaluationMatrix();
    private final EvaluationService evaluationService = new EvaluationService();

    private final EvaluationStack evaluationStack = new EvaluationStack();

    private final String mathExpression; // входящее выражение
    private int expressionParsingIndex = 0; // позиция распарсивания (кажется)

    public EvaluationContext(String mathExpression) {
        this.mathExpression = mathExpression;
    }

    public String getMathExpression() {
        return mathExpression;
    }

    public int getExpressionParsingIndex() {
        return expressionParsingIndex;
    }

    public void setExpressionParsingIndex(int expressionParsingIndex) {
        this.expressionParsingIndex = expressionParsingIndex;
    }

    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    @Override
    public TransitionMatrix<State> getTransitionMatrix() {
        return matrix;
    }

    @Override
    public StateAcceptor<State, EvaluationContext> getStateAcceptor() {
        return evaluationService;
    }
}
