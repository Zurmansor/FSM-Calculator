package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationParser implements MathExpressionParser {

    private static Logger logger = Logger.getLogger(OperationParser.class.getName());

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final String mathExpression = context.getMathExpression(); // берем выражение
        final int index = context.getExpressionParsingIndex(); // берем позицию в выражении
        Operation operation;

        if (index >= mathExpression.length()) {
            return null;
        }

        switch (mathExpression.charAt(index)) {
            case '+':
                logger.log(Level.INFO, "operation parsed: +");
                operation = Operation.ADDITION;
                break;
            case '-':
                logger.log(Level.INFO, "operation parsed: -");
                operation = Operation.SUBTRACTION;
                break;
            default:
                return null;
        }

        context.setExpressionParsingIndex(index + 1); // смещаем index на 1

        final Operation finalOperation = operation;
        return new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) {
                stack.getOperationStack().push(finalOperation);
            }
        };
    }
}
