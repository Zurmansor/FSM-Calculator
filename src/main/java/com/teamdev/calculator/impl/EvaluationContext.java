package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.fsm.StateAcceptor;
import com.teamdev.fsm.StateMachineContext;
import com.teamdev.fsm.TransitionMatrix;

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

    public boolean isFunction() {
        return isFunction;
    }

    public void setFunctionFlag(Boolean flag) {
        isFunction = flag;
    }

    public boolean isTempFunction() {
        return isTempFunction;
    }

    public void setTempFunctionFlag(Boolean flag) {
        isTempFunction = flag;
    }

//    public void setBracketFlag() {
//        isFunction = false;
//    }

    public EvaluationContext(String mathExpression) {
        expressionReader = new MathExpressionReader(mathExpression);
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
