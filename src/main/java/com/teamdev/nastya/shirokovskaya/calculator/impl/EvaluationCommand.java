package com.teamdev.nastya.shirokovskaya.calculator.impl;

import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;

public interface EvaluationCommand {
    void evaluate(EvaluationStack stack) throws EvaluationException;
}
