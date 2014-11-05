package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.*;

import static com.teamdev.calculator.impl.parser.MathExpressionSymbols.OPENING_BRACKET;

public class OpeningBracketParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(final EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return null;
        }

        if (expressionReader.currentChar() == OPENING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    //сохраняем в стек флагов текущее состояние флага
                    context.getEvaluationStack().getFlagStack().push(context.isFunction());
                    context.setFunctionFlag(context.isTempFunction());
                    context.setTempFunctionFlag(false);

                    stack.pushOpeningBracket(context);
                }
            };
        }

        return null;
    }
}
