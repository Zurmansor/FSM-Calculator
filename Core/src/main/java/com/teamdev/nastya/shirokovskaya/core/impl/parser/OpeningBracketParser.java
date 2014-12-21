package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OpeningBracketParser implements MathExpressionParser {
    private static Logger LOG = Logger.getLogger(OpeningBracketParser.class.getName());
    /**
     * Parses the opening bracket.
     * @param context
     * @return Optional<EvaluationCommand>
     */
    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing opening bracket");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return Optional.absent();
        }

        if (expressionReader.currentChar() == MathExpressionSymbols.OPENING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            EvaluationCommand evaluationCommand = new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    //save in the stack functionStatus the current status
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
