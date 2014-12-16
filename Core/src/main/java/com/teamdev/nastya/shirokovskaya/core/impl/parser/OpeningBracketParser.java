package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.teamdev.nastya.shirokovskaya.core.impl.*;

public class OpeningBracketParser implements MathExpressionParser {
    /**
     * Parses the opening bracket.
     * @param context
     * @return
     */
    @Override
    public EvaluationCommand parse(final EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return null;
        }

        if (expressionReader.currentChar() == MathExpressionSymbols.OPENING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    //сохраняем в стек флагов текущее состояние флага
                    context.getEvaluationStack().getFunctionStatusStack().push(context.getCurrentFunctionStatus());
                    context.setCurrentFunctionStatus(context.getPreviousFunctionStatus());
                    context.setPreviousFunctionStatus(false);

                    stack.pushOpeningBracket(context);
                }
            };
        }

        return null;
    }
}
