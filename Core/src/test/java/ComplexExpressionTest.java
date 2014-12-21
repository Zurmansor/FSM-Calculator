/*
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ComplexExpressionTest {

    @Test
    public void testFunctionSqrtMin() throws EvaluationException {
        String testExpression = "sqrt(min(174, 81, 357))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(9.0, result);
    }

    @Test
    public void testNotDeeplyNestedComma() throws EvaluationException {
        String testExpression = "max(1, 7 + min (5,-3,2))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(4.0, result);
    }

    @Test(expected = EvaluationException.class)
    public void testDeeplyNestedComma() throws EvaluationException {
        String testExpression = "max(1, 7 + min (5,-3,2), (5,7))";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test
    public void testDifferentBracketsInSuccession() throws EvaluationException {
        String testExpression = "max((81 + 3),7)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(84.0, result);
    }

    @Test
    public void testComplexExpressionDifferentBracketsInSuccession() throws EvaluationException {
        String testExpression = "max(((2*3)-4),min(81, 3),7 + 9, sum(17, 10))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(27.0, result);
    }

    @Test(expected=EvaluationException.class)
    public void testComplexExpressionFunctionNegativeArgumentSqrt() throws EvaluationException {
        String testExpression = "sqrt(min(-81, 79, 10, sqrt(9)))";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test
    public void testComplexExpressionFunctionWithFunctionArgument() throws EvaluationException {
        String testExpression = "sum(sqrt(9), max(5, 4), min(7, 1, 6), abs(-3))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(12.0, result);
    }
}

*/