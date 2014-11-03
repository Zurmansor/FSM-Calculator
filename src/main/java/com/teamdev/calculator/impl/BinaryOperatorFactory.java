package com.teamdev.calculator.impl;

import com.teamdev.calculator.impl.operator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BinaryOperatorFactory {

    private final Map<String, BinaryOperator> registry = new HashMap<String, BinaryOperator>() {{
        put("+", new PlusBinaryOperator());
        put("-", new MinusBinaryOperator());
        put("*", new MultiplyBinaryOperator());
        put("/", new DivideBinaryOperator());
        put("^", new PowerBinaryOperator());
    }};

    public BinaryOperator create(String operatorPresentation) {
        return registry.get(operatorPresentation);
    }

    public Set<String> getAvailableOperatorPresentations() {
        return registry.keySet();
    }
}