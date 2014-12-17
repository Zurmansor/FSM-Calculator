package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.google.common.base.Optional;
import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberParser implements MathExpressionParser {

    private static Logger LOG = Logger.getLogger(NumberParser.class.getName());
    private final DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    /**
     * Parses the number.
     * @param context
     * @return Optional<EvaluationCommand>.
     */
    @Override
    public Optional<EvaluationCommand> parse(EvaluationContext context) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "Parsing number");
        }
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final String mathExpression = expressionReader.getMathExpression();
        final int index = expressionReader.getIndex();

        final ParsePosition parsePosition = new ParsePosition(index);

        otherSymbols.setDecimalSeparator('.');
        DecimalFormat numberFormat = new DecimalFormat("#.#", otherSymbols);

        final Number number = numberFormat.parse(mathExpression, parsePosition);
        if (parsePosition.getErrorIndex() != -1) {
            return Optional.absent();
        }

        expressionReader.setIndex(parsePosition.getIndex());

        EvaluationCommand evaluationCommand = new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) {
                stack.getOperandStack().push(number.doubleValue());
            }
        };

        return Optional.of(evaluationCommand);
    }
}
