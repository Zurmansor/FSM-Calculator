package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.teamdev.nastya.shirokovskaya.core.impl.parser.MathExpressionSymbols.CLOSING_BRACKET;

public class ClosingBracketParser implements MathExpressionParser {
    private static Logger LOG = Logger.getLogger(ClosingBracketParser.class.getName());
    /**
     * Parses the closing bracket.
     * @param context
     * @return Optional<EvaluationCommand>
     */
    @Override
    public Optional<EvaluationCommand> parse(final EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing closing bracket");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return Optional.absent();
        }

        if (expressionReader.currentChar() == CLOSING_BRACKET.getSymbol()) {
            expressionReader.incrementIndex(1);
            EvaluationCommand evaluationCommand = new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {

                    if (stack.getBracketStack().isEmpty()) {
                        throw new EvaluationException("Opening bracket expected",
                                expressionReader.getIndex());
                    }
                    stack.pushClosingBracket(context);
                    //at the closing brackets take from the current state of the stack function.
                    context.setCurrentFunctionStatus(context.getEvaluationStack().getFunctionStatusStack().pop());
                }
            };
            return Optional.of(evaluationCommand);
        }

        return Optional.absent();
    }
}
