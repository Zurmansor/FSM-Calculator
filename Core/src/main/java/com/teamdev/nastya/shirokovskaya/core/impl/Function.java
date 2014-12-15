package com.teamdev.nastya.shirokovskaya.core.impl;

import com.teamdev.nastya.shirokovskaya.core.EvaluationException;

public interface Function {

    double perform(Double... args) throws EvaluationException;
}