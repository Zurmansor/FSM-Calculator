package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements MathExpressionParser {

    private final NumberFormat numberFormat = DecimalFormat.getNumberInstance(Locale.US);

    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final String mathExpression = expressionReader.getMathExpression();
        final int index = expressionReader.getIndex();

        final ParsePosition parsePosition = new ParsePosition(index);
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
