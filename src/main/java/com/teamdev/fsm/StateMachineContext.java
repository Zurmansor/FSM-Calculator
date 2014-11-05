package com.teamdev.fsm;

public interface StateMachineContext<State extends Enum,
        Context extends StateMachineContext<State, Context, TransitionError>,
        TransitionError extends Exception> {

    TransitionMatrix<State> getTransitionMatrix();

    StateAcceptor<State, Context, TransitionError> getStateAcceptor();

    boolean isFunction();
}
