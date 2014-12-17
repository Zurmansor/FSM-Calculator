package com.teamdev.nastya.shirokovskaya.core.impl.operator;

import com.google.common.base.Preconditions;

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
    public double calculate(double leftOperand, double rightOperand) throws IllegalArgumentException{
        Preconditions.checkArgument(rightOperand != 0, "division by zero");
        return leftOperand / rightOperand;
    }
}

