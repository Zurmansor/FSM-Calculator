package com.teamdev.nastya.shirokovskaya.core.impl.parser;


import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
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

        final String variable = matcher.group();
        final String finalVariable = variable;
        FunctionFactory functionFactory = new FunctionFactory();

        if (functionFactory.getAvailableFunctionPresentations().contains(variable)) {
            return Optional.absent();
        }
        expressionReader.incrementIndex(variable.length());

        EvaluationCommand evaluationCommand = new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) throws EvaluationException {

                if (Strings.isNullOrEmpty(context.getCurrentVariable())) {
                    // left of equal
                    context.setcurrentVariable(variable);
                    if (LOG.isLoggable(Level.INFO)) {
                        LOG.log(Level.INFO, "Variable has been parsed - " + variable);
                    }
                } else {
                    // right of equal
                    Preconditions.checkState(stack.getVariableMap().containsKey(variable), "Variable " + variable + " is not contains value");
                    double variableValue = stack.getVariableMap().get(variable);
                    if (LOG.isLoggable(Level.INFO)) {
                        LOG.log(Level.INFO, "Variable has been parsed: " + variable + "=" + variableValue);
                    }
                    stack.getOperandStack().push(variableValue);
                }

            }
        };
        return Optional.of(evaluationCommand);
    }
}
