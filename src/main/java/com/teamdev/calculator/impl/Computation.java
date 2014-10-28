package com.teamdev.calculator.impl;

import java.util.Deque;

public class Computation {

    public Double calculate(EvaluationContext context) {

        Deque<Double> operandStack = context.getEvaluationStack().getOperandStack();
        Deque<Operation> operationStack = context.getEvaluationStack().getOperationStack();

        if (operandStack.isEmpty()) {
            return 0.0;
        }

        while (!operationStack.isEmpty()) {
            Double temp = calc(operandStack.pop(), operandStack.pop(), operationStack.pop());
            operandStack.push(temp);
        }

    return operandStack.pop();
    }

    Double calc (Double operand1,Double operand2, Operation operation){

        switch (operation) {
            case ADDITION:
                return operand2 + operand1;
            case SUBTRACTION:
                return operand2 - operand1;

            default:
                return null;
        }
    }

}