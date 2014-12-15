package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class EvaluationStack {
    private final Deque<Double> operandStack = new ArrayDeque<Double>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<BinaryOperator>();
    private final Deque<Integer> bracketStack = new ArrayDeque<Integer>();
    private final Deque<Function> functionStack = new ArrayDeque<Function>();
    private final Deque<Boolean> flagStack = new ArrayDeque<Boolean>();


    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<BinaryOperator> getOperatorStack() {
        return operatorStack;
    }

    public Deque<Integer> getBracketStack() {
        return bracketStack;
    }

    public Deque<Function> getFunctionStack() {
        return functionStack;
    }

    public Deque<Boolean> getFlagStack() {
        return flagStack;
    }

    /**
     * Places the current operator in the operatorStack.
     * @param binaryOperator
     */
    public void pushOperator(BinaryOperator binaryOperator) {

        while (!operatorStack.isEmpty()
                && (bracketStack.isEmpty() || operatorStack.size() > bracketStack.peek())
                && operatorStack.peek().compareTo(binaryOperator) > -1
                && !binaryOperator.isRightAssociated()) {
            executeTopOperator();
        }

        operatorStack.push(binaryOperator);
    }

    /**
     * Places the current function in the functionStack.
     * @param function
     */
    public void pushFunction(Function function) {
        functionStack.push(function);
    }

    /**
     * Places the current flag in the flagStack.
     * @param flag
     */
    public void pushFlag(Boolean flag){
        flagStack.push(flag);
    }

    /**
     * To perform the operation on the upper operands.
     */
    public void executeTopOperator() {
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final BinaryOperator operator = operatorStack.pop();
        final double result = operator.calculate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    /**
     * Pull out all the remaining operations of the stack.
     */
    public void popAllOperators() {
        while (!operatorStack.isEmpty()) {
            executeTopOperator();
        }
    }

    /**
     * Pull off the stack opening bracket.
     * @param context
     */
    public void pushOpeningBracket(EvaluationContext context) {
        if (context.isFunction()){
            bracketStack.push(operandStack.size());
            bracketStack.push(operatorStack.size());
        } else {
            bracketStack.push(operatorStack.size());
        }
    }

    /**
     * pull off the stack closing bracket
     * @param context
     * @throws EvaluationException
     */
    public void pushClosingBracket(EvaluationContext context) throws EvaluationException {

        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize) {
            executeTopOperator();
        }
        // handle bracket as usual , and then check whether it is functional
        if (context.isFunction()) {
            final Integer operandStackSize = bracketStack.pop();

            final ArrayList<Double> args = new ArrayList<Double>();
            while (operandStack.size() > operandStackSize) {
                args.add(operandStack.pop());
            }

            final Function function = functionStack.peek();
            final double result = function.perform((Double[]) args.toArray(new Double[args.size()]));
            operandStack.push(result);
            functionStack.pop();
        }
    }

    /**
     * Pull off the stack closing comma.
     */
    public void pushClosingComma() {
        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize){
            executeTopOperator();
        }
    }

    /**
     * Pull off the stack opening comma.
     */
    public void pushOpeningComma() {
        bracketStack.push(operatorStack.size());
    }
}
