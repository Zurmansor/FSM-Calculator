package com.teamdev.fsm;

public abstract class FiniteStateMachine<State extends Enum,
        Context extends StateMachineContext<State, Context>,
        Result> {

    public Result run(Context context) {
// проходим по всем состояниям
        final TransitionMatrix<State> matrix = context.getTransitionMatrix();
        State currentState = matrix.getStartState();

        while (currentState != matrix.getFinishState()) {

            final State nextState = moveForward(context, currentState);
            if (nextState == null) {
                deadlock(context, currentState);
            }
            currentState = nextState;
        }

        return finish(context);
    }
// переход в следущее состояние
    private State moveForward(Context context, State currentState) {

        final StateAcceptor<State, Context> stateAcceptor = context.getStateAcceptor();
        final TransitionMatrix<State> matrix = context.getTransitionMatrix();

        // находит и возвращает первое предпологаемое состояние (possibleState), которе удалось распарсить
        for (State possibleState : matrix.getPossibleStates(currentState)) {
            if (stateAcceptor.acceptState(context, possibleState)) {
                return possibleState;
            }
        }
        return null;
    }

    abstract protected void deadlock(Context context, State currentState);

    abstract protected Result finish(Context context);
}
