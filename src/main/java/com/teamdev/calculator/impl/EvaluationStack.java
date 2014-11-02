package com.teamdev.calculator.impl;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationStack {

    private final Deque<Double> operandStack = new ArrayDeque<Double>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<BinaryOperator>();
    private final Deque<Integer> bracketStack = new ArrayDeque<Integer>();

    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<BinaryOperator> getOperatorStack() {
        return operatorStack;
    }

    public Deque<Integer> getBracketStack() {
        return bracketStack;
    }

    public void pushOperator(BinaryOperator binaryOperator) {

        while (!operatorStack.isEmpty() && operatorStack.peek().compareTo(binaryOperator) > -1) {
            executeTopOperator();
        }

        operatorStack.push(binaryOperator);
    }

    public void executeTopOperator() {
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final BinaryOperator operator = operatorStack.pop();
        final double result = operator.calculate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    public void popAllOperators() {
        while (!operatorStack.isEmpty()) {
            executeTopOperator();
        }
    }

    public void pushOpeningBracket() {
        bracketStack.push(operatorStack.size());
    }

    public void pushClosingBracket() {
        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize) {
            executeTopOperator();
        }
    }
}
