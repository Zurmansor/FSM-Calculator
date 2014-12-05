package com.teamdev.nastya.shirokovskaya.calculator.impl;


public interface BinaryOperator extends Comparable<BinaryOperator> {
    boolean isRightAssociated();
    double calculate(double leftOperand, double rightOperand);
}
