package com.teamdev.calculator.impl;

public enum State {
    START,
    NUMBER,
    BINARY_OPERATOR,
    OPENING_BRACKET,
    CLOSING_BRACKET,
    FUNCTION,
    COMMA,
    FINISH
}
