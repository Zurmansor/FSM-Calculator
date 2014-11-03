package com.teamdev.calculator.impl.function;

public class MinFunction extends  AbstractFunction{
    @Override
    public double perform(double leftOperand, double rightOperand) {
        return Math.min(leftOperand, rightOperand);
    }

}