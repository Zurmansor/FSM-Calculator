package com.teamdev.calculator.impl.operator;

import static com.teamdev.calculator.impl.operator.AbstractBinaryOperator.Priority.LOW;

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
        return LOW;
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

