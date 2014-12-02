package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.HIGH;

public class PowerBinaryOperator extends AbstractBinaryOperator {

    @Override
    public boolean isRightAssociated() {
        return true;
    }

    @Override
    protected Priority getPriority() {
        return HIGH;
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

