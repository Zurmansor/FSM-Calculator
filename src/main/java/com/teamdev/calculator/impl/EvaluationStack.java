package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
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

    public void pushOperator(BinaryOperator binaryOperator) {

        while (!operatorStack.isEmpty()
                && (bracketStack.isEmpty() || operatorStack.size() > bracketStack.peek())
                && operatorStack.peek().compareTo(binaryOperator) > -1) {
            executeTopOperator();
        }

        operatorStack.push(binaryOperator);
    }

    public void pushFunction(Function function) {
        functionStack.push(function);
    }

    public void pushFlag(Boolean flag){
        flagStack.push(flag);
    }



    public void executeTopOperator() {
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final BinaryOperator operator = operatorStack.pop();
        final double result = operator.calculate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    /*
    public void executeTopFunction() {
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final Function function = functionStack.peek();
        final double result = function.perform(leftOperand, rightOperand);
        operandStack.push(result);
    }
    */

    public void popAllOperators() {
        while (!operatorStack.isEmpty()) {
            executeTopOperator();
        }
    }

    public void pushOpeningBracket(EvaluationContext context) {
        if (context.isFunction()){
            bracketStack.push(operandStack.size());
            bracketStack.push(operatorStack.size());
        } else {
            bracketStack.push(operatorStack.size());
        }
    }

    public void pushClosingBracket(EvaluationContext context) throws EvaluationException {

        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize) {
            executeTopOperator();
        }
        // отрабатываем скобку как обычную, а потом проверяем функциональна ли она
        if (context.isFunction()) {
            final Integer operandStackSize = bracketStack.pop();

//            final double result = function.calculate((Double[]) arguments.toArray(new Double[0]));

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

    public void pushClosingComma() {
        final Integer operatorStackSize = bracketStack.pop();

        while (operatorStack.size() > operatorStackSize){
            executeTopOperator();
        }
    }

    public void pushOpeningComma() {
        bracketStack.push(operatorStack.size());
    }
}
