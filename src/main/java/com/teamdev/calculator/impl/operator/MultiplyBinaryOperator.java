package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.MEDIUM;

public class MultiplyBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return false;
    }

    @Override
    protected Priority getPriority() {
        return MEDIUM;
    }

    /**
     * Multiplication of input parameters
     * @param leftOperand
     * @param rightOperand
     * @return result of multiplication
     */
    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}

