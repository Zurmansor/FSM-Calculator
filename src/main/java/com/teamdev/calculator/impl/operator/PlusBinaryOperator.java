package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.LOW;

public class PlusBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return false;
    }

    @Override
    protected Priority getPriority() {
        return LOW;
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}

