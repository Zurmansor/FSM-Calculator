package com.teamdev.nastya.shirokovskaya.core.impl.parser;

import com.teamdev.nastya.shirokovskaya.core.impl.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements MathExpressionParser {

    private final DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);

    /**
     * Parses the number.
     * @param context
     * @return Evaluation command.
     */
    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final String mathExpression = expressionReader.getMathExpression();
        final int index = expressionReader.getIndex();

        final ParsePosition parsePosition = new ParsePosition(index);

        otherSymbols.setDecimalSeparator('.');
        DecimalFormat numberFormat = new DecimalFormat("#.#", otherSymbols);

        final Number number = numberFormat.parse(mathExpression, parsePosition);
        if (parsePosition.getErrorIndex() != -1) {
            return null;
        }

        expressionReader.setIndex(parsePosition.getIndex());

        return new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) {
                stack.getOperandStack().push(number.doubleValue());
            }
        };
    }
}
