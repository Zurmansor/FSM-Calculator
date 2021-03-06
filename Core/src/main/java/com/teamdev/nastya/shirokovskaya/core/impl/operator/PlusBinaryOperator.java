package com.teamdev.nastya.shirokovskaya.core.impl.operator;

/**
 * Addition operation
 */
public class PlusBinaryOperator extends AbstractBinaryOperator {


    @Override
    public boolean isRightAssociated() {
        return false;
    }


    @Override
    protected Priority getPriority() {
        return Priority.LOW;
    }

    /**
     * Addition of input parameters
     * @param leftOperand
     * @param rightOperand
     * @return result of addition
     */
    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}

