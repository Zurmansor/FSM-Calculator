package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.*;

import static com.teamdev.calculator.impl.parser.MathExpressionSymbols.CLOSING_BRACKET;

public class ClosingBracketParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(final EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return null;
        }

        if (expressionReader.currentChar() == CLOSING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {

                    if (stack.getBracketStack().isEmpty()) {
                        throw new EvaluationException("Opening bracket expected.",
                                expressionReader.getIndex());
                    }

                    stack.pushClosingBracket(context);
                }
            };
        }

        return null;
    }
}
