package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.impl.operator.*;

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

    /**
     * Creates an element of a given type.
     * @param operatorPresentation
     * @return
     */
    public BinaryOperator create(String operatorPresentation) {
        return registry.get(operatorPresentation);
    }

    /**
     * Returns all existing operations in the factory.
     * @return
     */
    public Set<String> getAvailableOperatorPresentations() {
        return registry.keySet();
    }
}