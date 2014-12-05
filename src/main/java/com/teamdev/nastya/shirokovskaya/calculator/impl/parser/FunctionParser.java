package com.teamdev.nastya.shirokovskaya.calculator.impl.parser;

import com.teamdev.nastya.shirokovskaya.calculator.impl.*;

public class FunctionParser implements MathExpressionParser {
    /**
     * Parses the function.
     * @param context
     * @return Evaluation command.
     */
    @Override
    public EvaluationCommand parse(final EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final FunctionFactory factory = context.getFunctionFactory();

        // remaining expression after the last parser
        final String remainingExpression = expressionReader.getRemainingExpression();
        // pass on all existing binary operations
        for (String presentation : factory.getAvailableFunctionPresentations()) {
            // if the remaining expression begins with a step
            if (remainingExpression.startsWith(presentation)) {
                expressionReader.incrementIndex(presentation.length());
                final Function function = factory.create(presentation);

                return new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) {
                        stack.pushFunction(function);
                        // announces that the next bracket will be functional
                        context.setTempFunctionFlag(true);
                    }
                };
            }
        }

        return null;
    }
}
