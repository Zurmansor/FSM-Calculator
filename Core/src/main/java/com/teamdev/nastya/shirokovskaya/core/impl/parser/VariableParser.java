package com.teamdev.nastya.shirokovskaya.core.impl.parser;


import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableParser implements MathExpressionParser{
    private static Logger LOG = Logger.getLogger(VariableParser.class.getName());

    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing variable");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final String remainingExpression = expressionReader.getRemainingExpression();

        Pattern pattern = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9_]*");
        Matcher matcher = pattern.matcher(remainingExpression);

        if (!matcher.find()) {
            return Optional.absent();
        }

        String variable = matcher.group();
        final String finalVariable = variable;
        expressionReader.incrementIndex(variable.length());

        EvaluationCommand evaluationCommand = new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) throws EvaluationException {
                stack.getVariableMap().put(finalVariable, null);

                if (LOG.isLoggable(Level.INFO)) {
                    LOG.log(Level.INFO, "Variable added to map: " + finalVariable);
                }
            }
        };
        return Optional.of(evaluationCommand);
    }
}
