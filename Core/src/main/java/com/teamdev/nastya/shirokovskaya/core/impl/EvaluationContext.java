package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.fsm.StateAcceptor;
import com.teamdev.nastya.shirokovskaya.fsm.StateMachineContext;
import com.teamdev.nastya.shirokovskaya.fsm.TransitionMatrix;

public class EvaluationContext implements StateMachineContext<State,
        EvaluationContext, EvaluationException> {

    private final EvaluationMatrix matrix = new EvaluationMatrix();
    private final EvaluationService evaluationService = new EvaluationService();
    private final BinaryOperatorFactory binaryOperatorFactory = new BinaryOperatorFactory();
    private final FunctionFactory functionFactory = new FunctionFactory();
    private final EvaluationStack evaluationStack = new EvaluationStack();
    private final MathExpressionReader expressionReader;
    private boolean isFunction = false;
    private boolean isTempFunction = false;

    public EvaluationContext(String mathExpression) {
        expressionReader = new MathExpressionReader(mathExpression);
    }

    /**
     * Determination if we're inside a function or in ordinary brackets.
     * @return
     */
    public boolean isFunction() {
        return isFunction;
    }

    /**
     * Setting a flag if we in functional brackets.
     * @param flag
     */
    public void setFunctionFlag(Boolean flag) {
        isFunction = flag;
    }

    /**
     * Determination state flag previous brackets.
     * @return
     */
    public boolean isTempFunction() {
        return isTempFunction;
    }

    /**
     * Setting a flag for the previous brackets.
     * @param flag
     */
    public void setTempFunctionFlag(Boolean flag) {
        isTempFunction = flag;
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

    @Override
    public StateAcceptor<State, EvaluationContext, EvaluationException> getStateAcceptor() {
        return evaluationService;
    }
}
