package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.teamdev.nastya.shirokovskaya.core.impl.*;

import static com.teamdev.nastya.shirokovskaya.core.impl.parser.MathExpressionSymbols.COMMA;

public class CommaParser implements MathExpressionParser {
    /**
     * Parses the comma.
     * @param context
     * @return Evaluation command.
     */
    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return null;
        }

        if (expressionReader.currentChar() == COMMA.getSymbol()) {
            expressionReader.incrementIndex(1);
            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    stack.pushClosingComma();
                    stack.pushOpeningComma();
                }
            };
        }

        return null;
    }
}