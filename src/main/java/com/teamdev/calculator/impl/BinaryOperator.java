package com.teamdev.calculator.impl;

public interface BinaryOperator extends Comparable<BinaryOperator> {
    double calculate(double leftOperand, double rightOperand);
}
