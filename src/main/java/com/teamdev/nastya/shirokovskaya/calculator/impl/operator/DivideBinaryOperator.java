package com.teamdev.nastya.shirokovskaya.calculator.impl.operator;

public class DivideBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return false;
    }

    @Override
    protected Priority getPriority() {
        return Priority.MEDIUM;
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

