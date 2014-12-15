package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.parser.*;
import com.teamdev.nastya.shirokovskaya.fsm.StateAcceptor;

import static com.teamdev.nastya.shirokovskaya.core.impl.State.*;
import java.util.HashMap;
import java.util.Map;

public class EvaluationService implements StateAcceptor<State, EvaluationContext, EvaluationException> {
    /**
     * State table and the corresponding parser for it.
     */
    private final Map<State, MathExpressionParser> parsers = new HashMap<State, MathExpressionParser>() {{
        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());
        put(OPENING_BRACKET, new OpeningBracketParser());
        put(CLOSING_BRACKET, new ClosingBracketParser());
        put(FUNCTION, new FunctionParser());
        put(COMMA, new CommaParser());
        put(FINISH, new EndOfExpressionParser());
    }};

    /**
     * Return true if successful parse the current state.
     * @param context
     * @param possibleState
     * @return
     * @throws EvaluationException
     */
    @Override
    public boolean acceptState(EvaluationContext context, State possibleState) throws EvaluationException {

        final MathExpressionParser parser = parsers.get(possibleState);

        if (parser == null) {
            throw new IllegalStateException("Parser not found for state: " + possibleState);
        }

        context.getExpressionReader().skipWhitespaces();

        if (context.getExpressionReader().getMathExpression().length() == 0) {
            throw new EvaluationException("expression is empty", 0);
        }

        final EvaluationCommand evaluationCommand = parser.parse(context);
        if (evaluationCommand == null) {
            return false;
        }

        evaluationCommand.evaluate(context.getEvaluationStack());

        return true;
    }
}
