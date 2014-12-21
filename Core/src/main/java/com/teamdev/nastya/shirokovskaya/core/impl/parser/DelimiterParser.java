package com.teamdev.nastya.shirokovskaya.core.impl.parser;


import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.teamdev.nastya.shirokovskaya.core.impl.parser.MathExpressionSymbols.DELIMITER;

public class DelimiterParser implements MathExpressionParser{

    private static Logger LOG = Logger.getLogger(VariableParser.class.getName());

    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing delimiter");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();

        String remainingExpression = expressionReader.getRemainingExpression();
        if (remainingExpression.startsWith(String.valueOf(DELIMITER.getSymbol()))) {
            expressionReader.incrementIndex(1);

            final MathExpressionReader reader = context.getExpressionReader();
            final EvaluationCommand evaluationCommand = new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {
                    if (!stack.getBracketStack().isEmpty()) {
                        throw new EvaluationException("Closing bracket expected", reader.getIndex());
                    }
                    stack.putSolutionOfVariableToMap(context);
                }
            };
            return Optional.of(evaluationCommand);
        }
        return Optional.absent();
    }
}
