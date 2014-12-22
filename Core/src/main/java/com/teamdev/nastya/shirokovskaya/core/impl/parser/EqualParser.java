package com.teamdev.nastya.shirokovskaya.core.impl.parser;


import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.teamdev.nastya.shirokovskaya.core.impl.parser.MathExpressionSymbols.EQUAL;

public class EqualParser implements MathExpressionParser{

    private static Logger LOG = Logger.getLogger(VariableParser.class.getName());
    
    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing equal");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();

        String remainingExpression = expressionReader.getRemainingExpression();
        if (remainingExpression.startsWith(String.valueOf(EQUAL.getSymbol()))) {
            expressionReader.incrementIndex(1);

            EvaluationCommand evaluationCommand = new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                }
            };
            return Optional.of(evaluationCommand);
        }
        return Optional.absent();
    }
}
