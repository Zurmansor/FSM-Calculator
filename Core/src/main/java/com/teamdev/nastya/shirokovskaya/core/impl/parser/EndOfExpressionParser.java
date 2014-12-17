package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EndOfExpressionParser implements MathExpressionParser {
    private static Logger LOG = Logger.getLogger(EndOfExpressionParser.class.getName());
    /**
     * Parses the end of the expression.
     * @param context
     * @return Optional<EvaluationCommand>
     * Optional.absent() if it`s not the end of expression, otherwise evaluation command.
     */
    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing end of expression");
        }
        final MathExpressionReader reader = context.getExpressionReader();

        if (!reader.endOfExpression()) {
            return Optional.absent();
        }

        EvaluationCommand evaluationCommand = new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) throws EvaluationException {

                if (!stack.getBracketStack().isEmpty()) {
                    throw new EvaluationException("Closing bracket expected", reader.getIndex());
                }

                stack.popAllOperators(context);
            }
        };
        return Optional.of(evaluationCommand);
    }
}
