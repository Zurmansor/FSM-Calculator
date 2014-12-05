package com.teamdev.nastya.shirokovskaya.calculator.impl.operator;

public class PowerBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return true;
    }

    @Override
    protected Priority getPriority() {
        return Priority.HIGH;
    }

    /**
     * Involution of input parameters
     * @param leftOperand
     * @param rightOperand
     * @return result of involution
     */
    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}

