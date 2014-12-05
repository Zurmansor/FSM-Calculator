package com.teamdev.nastya.shirokovskaya.calculator.impl;

import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;
import com.teamdev.nastya.shirokovskaya.calculator.MathExpressionCalculator;
import com.teamdev.nastya.shirokovskaya.fsm.FiniteStateMachine;
import com.teamdev.nastya.shirokovskaya.mvc.controller.Controller;
import com.teamdev.nastya.shirokovskaya.mvc.model.Model;
import com.teamdev.nastya.shirokovskaya.mvc.view.View;

public class StateMachineCalculator extends FiniteStateMachine<
        State, EvaluationContext, Double, EvaluationException>
        implements MathExpressionCalculator {

    private final static boolean UI = true;

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

    public double start(String mathExpression) throws EvaluationException{
        final StateMachineCalculator calculator = new StateMachineCalculator();
            final double result = calculator.evaluate(mathExpression);
            return result;
    }

    public static void main(String[] args) {
        final StateMachineCalculator calculator = new StateMachineCalculator();

        if (UI) {
            Model model = new Model();
            View view = new View();
            Controller controller = new Controller(model, view);
            controller.control();
        } else {
            final String mathExpression = "sqrt(4,7d)";
            try {
                System.out.println(mathExpression);
                double result = calculator.start(mathExpression);
                System.out.println("result = " + result);

            } catch (EvaluationException e) {
                String indent = "";
                while (indent.length() < e.getErrorIndex()) {
                    indent += " ";
                }
                System.out.println(indent + (char)(8593)); // code up arrow
                System.out.println("Calculation error: " + e.getMessage());
                System.out.println("at position " + e.getErrorIndex());
            }
        }
    }


}
