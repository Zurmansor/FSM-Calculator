package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.HIGH;

public class PowerBinaryOperator extends AbstractBinaryOperator {

    @Override
    protected Priority getPriority() {
        return HIGH;
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}

