package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryOperatorParser implements MathExpressionParser {
    private static Logger LOG = Logger.getLogger(BinaryOperatorParser.class.getName());
    /**
     * Parses the binary operation.
     * @param context
     * @return Optional<EvaluationCommand>.
     */
    @Override
    public Optional<EvaluationCommand> parse(EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing binary operator");
        }
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
                EvaluationCommand evaluationCommand = new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) {
                        stack.pushOperator(binaryOperator);
                    }
                };
                return Optional.of(evaluationCommand);
            }
        }

        return Optional.absent();
    }
}
