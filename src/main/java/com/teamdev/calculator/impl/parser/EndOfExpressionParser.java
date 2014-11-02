package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.*;

public class EndOfExpressionParser implements MathExpressionParser {

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
