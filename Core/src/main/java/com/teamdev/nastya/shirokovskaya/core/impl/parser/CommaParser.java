package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.teamdev.nastya.shirokovskaya.core.impl.parser.MathExpressionSymbols.COMMA;

public class CommaParser implements MathExpressionParser {
    private static Logger LOG = Logger.getLogger(CommaParser.class.getName());
    /**
     * Parses the comma.
     * @param context
     * @return Optional<EvaluationCommand>
     */
    @Override
    public Optional<EvaluationCommand> parse(EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing comma");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return Optional.absent();
        }

        if (expressionReader.currentChar() == COMMA.getSymbol()) {
            expressionReader.incrementIndex(1);
            EvaluationCommand evaluationCommand = new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    stack.pushClosingComma();
                    stack.pushOpeningComma();
                }
            };
            return Optional.of(evaluationCommand);
        }

        return Optional.absent();
    }
}