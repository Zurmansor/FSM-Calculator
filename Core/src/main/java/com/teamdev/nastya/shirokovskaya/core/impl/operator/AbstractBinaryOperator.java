package com.teamdev.nastya.shirokovskaya.core.impl.operator;

import com.teamdev.nastya.shirokovskaya.core.impl.BinaryOperator;

abstract public class AbstractBinaryOperator implements BinaryOperator {

    static enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    protected boolean isRightAssociated = false;

    /**
     * Check the right associativity
     * @return true if right associated
     */
    public abstract boolean isRightAssociated();

    /**
     * Receive priority operation
     * @return Priority operation
     */
    protected abstract Priority getPriority();

    /**
     * Compare operation priority
     * @param binaryOperator
     * @return a negative integer, zero, or a positive integer as this operation is less than,
     * equal to, or greater than the specified operation
     */
    @Override
    public int compareTo(BinaryOperator binaryOperator) {
        final AbstractBinaryOperator other = (AbstractBinaryOperator) binaryOperator;
        return getPriority().compareTo(other.getPriority());
    }
}