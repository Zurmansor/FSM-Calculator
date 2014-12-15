package com.teamdev.nastya.shirokovskaya.core.impl.operator;

public class MinusBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return false;
    }

    @Override
    protected Priority getPriority() {
        return Priority.LOW;
    }

    /**
     * Subtraction of input parameters
     * @param leftOperand
     * @param rightOperand
     * @return result of subtraction
     */
    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}

