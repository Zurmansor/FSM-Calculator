package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvaluationStack {
    private static Logger LOG = Logger.getLogger(EvaluationStack.class.getName());

    private final Deque<Double> operandStack = new ArrayDeque<Double>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<BinaryOperator>();
    private final Deque<Integer> bracketStack = new ArrayDeque<Integer>();
    private final Deque<Function> functionStack = new ArrayDeque<Function>();
    private final Deque<Boolean> functionStatusStack = new ArrayDeque<Boolean>();

    public Deque<Double> getOperandStack() {
        return operandStack;
    }
    public Deque<Integer> getBracketStack() {
        return bracketStack;
    }
    public Deque<Boolean> getFunctionStatusStack() {
        return functionStatusStack;
    }

    /**
     * Places the current operator in the operatorStack.
     * @param binaryOperator
     */
    public void pushOperator(EvaluationContext context, BinaryOperator binaryOperator) throws EvaluationException {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Pushing operator");
        }
        while (!operatorStack.isEmpty()
                && (bracketStack.isEmpty() || operatorStack.size() > bracketStack.peek())
                && operatorStack.peek().compareTo(binaryOperator) > -1
                && !binaryOperator.isRightAssociated()) {
            executeTopOperator(context);
        }
        operatorStack.push(binaryOperator);
    }

    /**
     * Places the current function in the functionStack.
     * @param function
     */
    public void pushFunction(Function function) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Pushing function");
        }
        functionStack.push(function);
    }

    /**
     * To perform the operation on the upper operands.
     */
    public void executeTopOperator(EvaluationContext context) throws EvaluationException {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Executing top operator");
        }
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final BinaryOperator operator = operatorStack.pop();
        try{
            final double result = operator.calculate(leftOperand, rightOperand);
            operandStack.push(result);
        } catch (IllegalArgumentException e) {
            throw new EvaluationException(e.getMessage(), context.getExpressionReader().getIndex());
        }
    }

    /**
     * Pull out all the remaining operations of the stack.
     */
    public void popAllOperators(EvaluationContext context) throws EvaluationException {
        while (!operatorStack.isEmpty()) {
            executeTopOperator(context);
        }
    }

    /**
     * Pull off the stack opening bracket.
     * @param context
     */
    public void pushOpeningBracket(EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Pushing opening bracket");
        }
        if (context.getCurrentFunctionStatus()){
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
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Pushing closing bracket");
        }
        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize) {
            executeTopOperator(context);
        }
        // handle bracket as usual, and then check whether it is functional
        if (context.getCurrentFunctionStatus()) {
            final Integer operandStackSize = bracketStack.pop();

            final ArrayList<Double> args = new ArrayList<Double>();
            while (operandStack.size() > operandStackSize) {
                args.add(operandStack.pop());
            }

            final Function function = functionStack.peek();
            try{
                final double result = function.perform((Double[]) args.toArray(new Double[args.size()]));
                operandStack.push(result);
                functionStack.pop();
            } catch (IllegalStateException e){
                throw new EvaluationException(e.getMessage(), context.getExpressionReader().getIndex());
            } catch (IllegalArgumentException e) {
                throw new EvaluationException(e.getMessage(), context.getExpressionReader().getIndex());
            }

        }
    }

    /**
     * Pull off the stack closing comma.
     */
    public void pushClosingComma(EvaluationContext context) throws EvaluationException {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Pushing closing comma");
        }
        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize){
            executeTopOperator(context);
        }
    }

    /**
     * Pull off the stack opening comma.
     */
    public void pushOpeningComma() {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Pushing opening comma");
        }
        bracketStack.push(operatorStack.size());
    }
}