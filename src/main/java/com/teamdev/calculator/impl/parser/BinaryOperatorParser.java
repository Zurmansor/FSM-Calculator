package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

public class BinaryOperatorParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final BinaryOperatorFactory factory = context.getBinaryOperatorFactory();

        // осташееся выражение после последнего парсера
        final String remainingExpression = expressionReader.getRemainingExpression();
        // проход по всем существующим бинарным операциями
        for (String presentation : factory.getAvailableOperatorPresentations()) {
            // если оставшееся выражение начинается с символа операции (одной из)...
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
