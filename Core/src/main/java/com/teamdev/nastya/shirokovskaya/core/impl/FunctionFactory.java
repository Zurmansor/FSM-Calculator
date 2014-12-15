package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.impl.function.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionFactory {

    private final Map<String, Function> registry = new HashMap<String, Function>(){{
        put("min", new MinFunction());
        put("max", new MaxFunction());
        put("sum", new SumFunction());
        put("sqrt", new SqrtFunction());
        put("abs", new AbsFunction());
    }};

    /**
     * Creates an element of a given type.
     * @param functionPresentation
     * @return
     */
    public Function create(String functionPresentation) {
        return registry.get(functionPresentation);
    }

    /**
     * Returns all existing functions in the factory.
     * @return
     */
    public Set<String> getAvailableFunctionPresentations() {
        return registry.keySet();
    }


}
