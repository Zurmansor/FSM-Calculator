package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.MEDIUM;

public class DivideBinaryOperator extends AbstractBinaryOperator {

    @Override
    protected Priority getPriority() {
        return MEDIUM;
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}

