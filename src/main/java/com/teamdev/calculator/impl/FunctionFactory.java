package com.teamdev.calculator.impl;

import com.teamdev.calculator.impl.function.MaxFunction;
import com.teamdev.calculator.impl.function.MinFunction;
import com.teamdev.calculator.impl.function.SumFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionFactory {

    private final Map<String, Function> registry = new HashMap<String, Function>(){{
        put("min", new MinFunction());
        put("max", new MaxFunction());
        put("sum", new SumFunction());
    }};

    public Function create(String functionPresentation) {
        return registry.get(functionPresentation);
    }

    public Set<String> getAvailableFunctionPresentations() {
        return registry.keySet();
    }


}
