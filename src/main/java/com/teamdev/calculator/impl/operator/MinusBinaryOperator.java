package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.LOW;

public class MinusBinaryOperator extends AbstractBinaryOperator {

    @Override
    protected Priority getPriority() {
        return LOW;
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}

