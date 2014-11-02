package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.MathExpressionCalculator;
import com.teamdev.fsm.FiniteStateMachine;
import com.teamdev.ui.MainForm;

public class StateMachineCalculator extends FiniteStateMachine<
        State, EvaluationContext, Double, EvaluationException>
        implements MathExpressionCalculator {

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
/*          try {
            System.out.println(mathExpression);
              final double result = calculator.evaluate(mathExpression);
              System.out.println("result = " + result);
          } catch (EvaluationException e) {
              System.out.println("Calculation error: " + e.getMessage());
              System.out.println("at position " + e.getErrorIndex());
          }*/
    }




    public static void main(String[] args) {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        new MainForm();
//            final String mathExpression = "(((2 + 2) + 2) + 2 * 2)";



  /*      try {
            final String mathExpression = "(((2 + 2) + 2) + 2 * 2)";
            System.out.println(mathExpression);
            final double result = calculator.evaluate(mathExpression);
            System.out.println("result = " + result);
        } catch (EvaluationException e) {
            System.out.println("Calculation error: " + e.getMessage());
            System.out.println("at position " + e.getErrorIndex());
        }*/
    }
}
