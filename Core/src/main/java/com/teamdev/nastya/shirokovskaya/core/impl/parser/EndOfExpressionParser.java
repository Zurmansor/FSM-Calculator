package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

public class EndOfExpressionParser implements MathExpressionParser {
    /**
     * Parses the end of the expression.
     * @param context
     * @return Optional.absent() if it`s not the end of expression, otherwise evaluation command.
     */
    @Override
    public Optional<EvaluationCommand> parse(EvaluationContext context) {
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

                stack.popAllOperators();
            }
        };
        return Optional.of(evaluationCommand);
    }
}
