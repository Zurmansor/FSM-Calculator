package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.MEDIUM;

public class DivideBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return false;
    }

    @Override
    protected Priority getPriority() {
        return MEDIUM;
    }

    /**
     * Division of input parameters
     * @param leftOperand
     * @param rightOperand
     * @return result of division
     */
    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}

