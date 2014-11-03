package com.teamdev.calculator.impl;

import com.teamdev.calculator.impl.function.MinFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionFactory {

    private final Map<String, Function> registry = new HashMap<String, Function>(){{
        put("min", new MinFunction());
    }};

    public Function create(String functionPresentation) {
        return registry.get(functionPresentation);
    }

    public Set<String> getAvailableFunctionPresentations() {
        return registry.keySet();
    }


}
