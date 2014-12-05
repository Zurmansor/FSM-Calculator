package com.teamdev.nastya.shirokovskaya.calculator.impl.parser;

import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;
import com.teamdev.nastya.shirokovskaya.calculator.impl.*;

import static com.teamdev.nastya.shirokovskaya.calculator.impl.parser.MathExpressionSymbols.CLOSING_BRACKET;

public class ClosingBracketParser implements MathExpressionParser {
    /**
     * Parses the closing bracket.
     * @param context
     * @return Evaluation command.
     */
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
                    //at the closing brackets take from the current state of the stack function.
                    context.setFunctionFlag(context.getEvaluationStack().getFlagStack().pop());
                }
            };
        }

        return null;
    }
}
