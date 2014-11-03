package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

public class FunctionParser implements MathExpressionParser{
    @Override
    public EvaluationCommand parse(final EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final FunctionFactory factory = context.getFunctionFactory();

        // осташееся выражение после последнего парсера
        final String remainingExpression = expressionReader.getRemainingExpression();
        // проход по всем существующим бинарным операциями
        for (String presentation : factory.getAvailableFunctionPresentations()) {
            // если оставшееся выражение начинается с символа операции (одной из)...
            if (remainingExpression.startsWith(presentation)) {

                expressionReader.incrementIndex(presentation.length());

                final Function function = factory.create(presentation);

                return new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) {
                        stack.pushFunction(function);
                        stack.pushFlag(context.isFunction());
                        context.setFunctionFlag(true);
                    }
                };
            }
        }

        return null;
    }
}
