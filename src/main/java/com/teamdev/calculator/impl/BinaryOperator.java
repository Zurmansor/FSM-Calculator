package com.teamdev.calculator.impl;

public interface BinaryOperator extends Comparable<BinaryOperator> {
    boolean isRightAssociated();
    double calculate(double leftOperand, double rightOperand);
}
