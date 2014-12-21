package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.fsm.TransitionMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import static com.teamdev.nastya.shirokovskaya.core.impl.State.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class EvaluationMatrix implements TransitionMatrix<State> {

    private final Map<State, Set<State>> transitions = new HashMap<State, Set<State>>() {{
        put(START, of(VARIABLE, NUMBER, OPENING_BRACKET, FUNCTION));
        put(VARIABLE, of(EQUAL));
        put(EQUAL, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(NUMBER, of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH, DELIMITER));
        put(COMMA, noneOf(State.class));
        put(FUNCTION, of(OPENING_BRACKET));
        put(BINARY_OPERATOR, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(OPENING_BRACKET, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(CLOSING_BRACKET, of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH, DELIMITER));
        put(DELIMITER, of(VARIABLE, FINISH));
        put(FINISH, noneOf(State.class));
    }};

    private final Map<State, Set<State>> functionTransitions = new HashMap<State, Set<State>>() {{
        put(NUMBER, of(COMMA));
        put(COMMA, of(NUMBER, OPENING_BRACKET, FUNCTION));
        put(CLOSING_BRACKET, of(COMMA));
    }};


    /**
     * Returns the initial state Start.
     * @return
     */
    @Override
    public State getStartState() {
        return START;
    }

    /**
     * Returns the final state.
     * @return
     */
    @Override
    public State getFinishState() {
        return FINISH;
    }

    /**
     * Returns the Set of all possible states.
     * @param state
     * @return
     */
    @Override
    public Set<State> getPossibleStates(State state) {
        return transitions.get(state);
    }

    /**
     * Returns the Set of all possible states of functions.
     * @param state
     * @return
     */
    @Override
    public Set<State> getPossibleFunctionStates(State state) {
        return functionTransitions.get(state);
    }
}
