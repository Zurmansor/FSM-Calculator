package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

import static com.teamdev.calculator.impl.parser.MathExpressionSymbols.OPENING_BRACKET;

public class OpeningBracketParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.currentChar() == OPENING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    stack.pushOpeningBracket();
                }
            };
        }

        return null;
    }
}
