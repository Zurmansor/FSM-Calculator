package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

public interface EvaluationCommand {
    void evaluate(EvaluationStack stack) throws EvaluationException;
}
