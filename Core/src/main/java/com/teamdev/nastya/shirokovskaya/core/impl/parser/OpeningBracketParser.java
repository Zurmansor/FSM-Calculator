package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

public class OpeningBracketParser implements MathExpressionParser {
    /**
     * Parses the opening bracket.
     * @param context
     * @return
     */
    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return Optional.absent();
        }

        if (expressionReader.currentChar() == MathExpressionSymbols.OPENING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            EvaluationCommand evaluationCommand = new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    //сохраняем в стек флагов текущее состояние флага
                    context.getEvaluationStack().getFunctionStatusStack().push(context.getCurrentFunctionStatus());
                    context.setCurrentFunctionStatus(context.getPreviousFunctionStatus());
                    context.setPreviousFunctionStatus(false);

                    stack.pushOpeningBracket(context);
                }
            };
            return Optional.of(evaluationCommand);
        }

        return Optional.absent();
    }
}
