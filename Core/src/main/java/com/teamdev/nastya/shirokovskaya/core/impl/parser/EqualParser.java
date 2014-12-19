package com.teamdev.nastya.shirokovskaya.core.impl.parser;


import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.EvaluationCommand;
import com.teamdev.nastya.shirokovskaya.core.impl.EvaluationContext;
import com.teamdev.nastya.shirokovskaya.core.impl.MathExpressionParser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EqualParser implements MathExpressionParser{

    private static Logger LOG = Logger.getLogger(VariableParser.class.getName());
    
    @Override
    public Optional<EvaluationCommand> parse(EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing equal");
        }
        return Optional.absent();
    }
}
