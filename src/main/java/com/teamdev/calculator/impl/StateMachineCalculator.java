package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.MathExpressionCalculator;
import com.teamdev.fsm.FiniteStateMachine;
import com.teamdev.ui.MainForm;

public class StateMachineCalculator extends FiniteStateMachine<
        State, EvaluationContext, Double, EvaluationException>
        implements MathExpressionCalculator {

    private static MainForm mainForm;
    private final static boolean UI = true;

//    private MainForm mainForm;

    @Override
    public double evaluate(String mathExpression) throws EvaluationException {
        return run(new EvaluationContext(mathExpression));
    }

    @Override
    protected void deadlock(EvaluationContext context, State currentState) throws EvaluationException {
        throw new EvaluationException("Incorrect expression format.",
                context.getExpressionReader().getIndex());
    }

    @Override
    protected Double finish(EvaluationContext context) {
        return context.getEvaluationStack().getOperandStack().pop();
    }

    public void start(String mathExpression) {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        try {
            System.out.println(mathExpression);
            final double result = calculator.evaluate(mathExpression);
            System.out.println("result = " + result);
            if (UI) {
                mainForm.setResult(result);
            }
        } catch (EvaluationException e) {
            String indent = "";
            while (indent.length() < e.getErrorIndex()) {
                indent += " ";
            }
            System.out.println(indent + (char)(8593)); // код стрелки вверх
            System.out.println("Calculation error: " + e.getMessage());
            System.out.println("at position " + e.getErrorIndex());

            if (UI) {
                mainForm.setError(e.getMessage(), e.getErrorIndex());
            }
        }
    }

    public static void main(String[] args) {
        final StateMachineCalculator calculator = new StateMachineCalculator();

        if (UI) {
            mainForm = new MainForm();
        } else {
            final String mathExpression = "sqrt(4,7d)";
            calculator.start(mathExpression);
        }
    }
}
