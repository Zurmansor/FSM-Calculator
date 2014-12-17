package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FunctionParser implements MathExpressionParser {
    private static Logger LOG = Logger.getLogger(FunctionParser.class.getName());
    /**
     * Parses the function.
     * @param context
     * @return Optional<EvaluationCommand>
     */
    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing function");
        }
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

                EvaluationCommand evaluationCommand = new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) {
                        stack.pushFunction(function);
                        // announces that the next bracket will be functional
                        context.setPreviousFunctionStatus(true);
                    }
                };
                return Optional.of(evaluationCommand);
            }
        }

        return Optional.absent();
    }
}
