package com.teamdev.calculator.impl;

import com.teamdev.fsm.TransitionMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teamdev.calculator.impl.State.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class EvaluationMatrix implements TransitionMatrix<State> {

    private final Map<State, Set<State>> transitions = new HashMap<State, Set<State>>() {{
        put(START, of(NUMBER, OPENING_BRACKET));
        put(NUMBER, of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH));
        put(BINARY_OPERATOR, of(NUMBER, OPENING_BRACKET));
        put(OPENING_BRACKET, of(NUMBER, OPENING_BRACKET));
        put(CLOSING_BRACKET, of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH));
        put(FINISH, noneOf(State.class));
    }};

    @Override
    public State getStartState() {
        return START;
    }

    @Override
    public State getFinishState() {
        return FINISH;
    }

    @Override
    public Set<State> getPossibleStates(State state) {
        return transitions.get(state);
    }
}
