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
        put(START, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(NUMBER, of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH));
        put(COMMA, noneOf(State.class));
        put(FUNCTION, of(OPENING_BRACKET));
        put(BINARY_OPERATOR, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(OPENING_BRACKET, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(CLOSING_BRACKET, of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH));
        put(FINISH, noneOf(State.class));
    }};

    private final Map<State, Set<State>> functionTransitions = new HashMap<State, Set<State>>() {{
        put(NUMBER, of(COMMA));
        put(COMMA, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(CLOSING_BRACKET, of(COMMA));
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

    @Override
    public Set<State> getPossibleFunctionStates(State state) {
        return functionTransitions.get(state);
    }
}
