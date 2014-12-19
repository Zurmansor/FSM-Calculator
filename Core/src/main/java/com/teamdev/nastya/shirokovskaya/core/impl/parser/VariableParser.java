package com.teamdev.nastya.shirokovskaya.core.impl.parser;


import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.EvaluationCommand;
import com.teamdev.nastya.shirokovskaya.core.impl.EvaluationContext;
import com.teamdev.nastya.shirokovskaya.core.impl.MathExpressionParser;
import com.teamdev.nastya.shirokovskaya.core.impl.MathExpressionReader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VariableParser implements MathExpressionParser{
    private static Logger LOG = Logger.getLogger(VariableParser.class.getName());

    @Override
    public Optional<EvaluationCommand> parse(EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing variable");
        }
//        final MathExpressionReader expressionReader = context.getExpressionReader();
        return Optional.absent();
    }
}
