package com.teamdev.calculator.impl;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.MathExpressionCalculator;
import com.teamdev.fsm.FiniteStateMachine;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StateMachineCalculator extends FiniteStateMachine<State, EvaluationContext, Double>
        implements MathExpressionCalculator {

    private static Logger logger = Logger.getLogger(StateMachineCalculator.class.getName());

    @Override
    public double evaluate(String mathExpression) throws EvaluationException {
        return run(new EvaluationContext(mathExpression));
    }

    @Override
    protected void deadlock(EvaluationContext context, State currentState) {
        throw new IllegalStateException("Deadlock in state " + currentState + " at position " +
                context.getExpressionParsingIndex());
    }

    @Override
    protected Double finish(EvaluationContext context) {
        Computation count = new Computation();
        return count.calculate(context);
    }

    public static void main(String[] args) throws Exception {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        String in = "1+(4-3)";
        logger.log(Level.INFO, in);

        final double result = calculator.evaluate(in);
        System.out.println("result = " + result);
    }
}
