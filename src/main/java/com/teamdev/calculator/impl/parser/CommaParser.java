package com.teamdev.calculator.impl.parser;


import com.teamdev.calculator.impl.*;

public class CommaParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final String remainingExpression = expressionReader.getRemainingExpression();

        if (remainingExpression.startsWith(",")) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
//                    do nothing
                }
            };
        }

        return null;
    }
}