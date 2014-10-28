package com.teamdev.calculator.impl;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationStack {
    private final Deque<Double> operandStack = new ArrayDeque<Double>();
    private final Deque<Operation> operationStack = new ArrayDeque<Operation>();
    private final Deque<Bracket> bracketStack = new ArrayDeque<Bracket>();

    public Deque<Double> getOperandStack() {
        return operandStack;
    }
    public Deque<Operation> getOperationStack() {
        return operationStack;
    }

    public Deque<Bracket> getBracketStack() {
        return bracketStack;
    }

}
