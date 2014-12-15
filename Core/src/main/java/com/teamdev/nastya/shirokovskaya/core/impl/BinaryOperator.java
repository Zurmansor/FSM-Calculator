package com.teamdev.nastya.shirokovskaya.core.impl;


public interface BinaryOperator extends Comparable<BinaryOperator> {
    boolean isRightAssociated();
    double calculate(double leftOperand, double rightOperand);
}
