package com.teamdev.calculator.impl.parser;

public enum MathExpressionSymbols {
    OPENING_BRACKET('('),
    CLOSING_BRACKET(')');

    private final char symbol;

    MathExpressionSymbols(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
