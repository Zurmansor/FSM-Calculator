package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.fsm.StateAcceptor;
import com.teamdev.nastya.shirokovskaya.fsm.StateMachineContext;
import com.teamdev.nastya.shirokovskaya.fsm.TransitionMatrix;

public class EvaluationContext implements StateMachineContext<State,
        EvaluationContext, EvaluationException> {

    private boolean currentFunctionStatus = false;
    private boolean previousFunctionStatus = false;
    private String currentVariable = null;
    private final EvaluationMatrix matrix = new EvaluationMatrix();
    private final EvaluationService evaluationService = new EvaluationService();
    private final BinaryOperatorFactory binaryOperatorFactory = new BinaryOperatorFactory();
    private final FunctionFactory functionFactory = new FunctionFactory();
    private final EvaluationStack evaluationStack = new EvaluationStack();
    private final MathExpressionReader expressionReader;

    public EvaluationContext(String mathExpression) {
        expressionReader = new MathExpressionReader(mathExpression);
    }

    /**
     * Determination if we're inside a function or in ordinary brackets.
     * @return
     */
    public boolean getCurrentFunctionStatus() {
        return currentFunctionStatus;
    }

     /**
     * Determination of previous brackets status.
     * @return
     */
    public boolean getPreviousFunctionStatus() {
        return previousFunctionStatus;
    }

    public MathExpressionReader getExpressionReader() {
        return expressionReader;
    }

    public BinaryOperatorFactory getBinaryOperatorFactory() {
        return binaryOperatorFactory;
    }

    public FunctionFactory getFunctionFactory() {
        return functionFactory;
    }

    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    @Override
    public TransitionMatrix<State> getTransitionMatrix() {
        return matrix;
    }

    public String getCurrentVariable() {
        return currentVariable;
    }

    /**
     * Setting a status for the previous brackets.
     * @param status
     */
    public void setPreviousFunctionStatus(Boolean status) {
        previousFunctionStatus = status;
    }

    /**
     * Determination of current brackets status.
     * @param status
     */
    public void setCurrentFunctionStatus(Boolean status) {
        currentFunctionStatus = status;
    }

    public void setcurrentVariable(String currentVariable) {
        this.currentVariable = currentVariable;
    }

    @Override
    public StateAcceptor<State, EvaluationContext, EvaluationException> getStateAcceptor() {
        return evaluationService;
    }
}
