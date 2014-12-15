package com.teamdev.nastya.shirokovskaya.core.impl.operator;

public class MultiplyBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return false;
    }

    @Override
    protected Priority getPriority() {
        return Priority.MEDIUM;
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

