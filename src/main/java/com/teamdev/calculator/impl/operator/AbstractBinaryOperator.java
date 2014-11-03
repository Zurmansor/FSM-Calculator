package com.teamdev.calculator.impl.operator;

import com.teamdev.calculator.impl.BinaryOperator;

abstract public class AbstractBinaryOperator implements BinaryOperator {

    static enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    protected abstract Priority getPriority();

    @Override
    public int compareTo(BinaryOperator binaryOperator) {
        final AbstractBinaryOperator other = (AbstractBinaryOperator) binaryOperator;
        return getPriority().compareTo(other.getPriority());
    }
}