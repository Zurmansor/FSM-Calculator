package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.teamdev.nastya.shirokovskaya.core.impl.*;

public class BinaryOperatorParser implements MathExpressionParser {
    /**
     * Parses the binary operation.
     * @param context
     * @return Evaluation command.
     */
    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final BinaryOperatorFactory factory = context.getBinaryOperatorFactory();

        // remaining expression after the last parser
        final String remainingExpression = expressionReader.getRemainingExpression();
        // pass on all existing binary operations
        for (String presentation : factory.getAvailableOperatorPresentations()) {
            // if the remaining expression begins with an operation.
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
