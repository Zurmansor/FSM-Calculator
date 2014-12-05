package com.teamdev.nastya.shirokovskaya.calculator.impl.parser;

import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;
import com.teamdev.nastya.shirokovskaya.calculator.impl.*;

public class EndOfExpressionParser implements MathExpressionParser {
    /**
     * Parses the end of the expression.
     * @param context
     * @return Null if it`s not the end of expression, otherwise evaluation command.
     */
    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader reader = context.getExpressionReader();

        if (!reader.endOfExpression()) {
            return null;
        }

        return new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) throws EvaluationException {

                if (!stack.getBracketStack().isEmpty()) {
                    throw new EvaluationException("Closing bracket expected.", reader.getIndex());
                }

                stack.popAllOperators();
            }
        };
    }
}
