package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

import java.util.logging.Level;

public class BracketParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final String mathExpression = context.getMathExpression(); // берем выражение
        final int index = context.getExpressionParsingIndex(); // берем позицию в выражении
        Bracket bracket;

        switch (mathExpression.charAt(index)) {
            case '(':
                bracket = Bracket.OPEN_BRACKET;
                break;
            case ')':
                bracket = Bracket.CLOSE_BRACKET;
                break;
            default:
                return null;
        }

        context.setExpressionParsingIndex(index + 1); // смещаем index на 1

        final Bracket finalBracket = bracket;
        return new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) {
                stack.getBracketStack().push(finalBracket);
            }
        };



    }
}
