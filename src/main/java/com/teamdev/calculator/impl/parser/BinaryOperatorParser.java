package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

public class BinaryOperatorParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final BinaryOperatorFactory factory = context.getBinaryOperatorFactory();

        final String remainingExpression = expressionReader.getRemainingExpression();
        for (String presentation : factory.getAvailableOperatorPresentations()) {
            if (remainingExpression.startsWith(presentation)) {

                expressionReader.incrementIndex(presentation.length());

                final BinaryOperator binaryOperator = factory.create(presentation);

                return new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) {
                        stack.pushOperator(binaryOperator);
                    }
                };
            }
        }

        return null;
    }
}
