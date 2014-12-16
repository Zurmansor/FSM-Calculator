package com.teamdev.nastya.shirokovskaya.core.impl;

import com.google.common.base.Optional;

public interface MathExpressionParser {
    Optional<EvaluationCommand> parse(EvaluationContext context);
}
