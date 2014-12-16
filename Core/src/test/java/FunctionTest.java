import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FunctionTest {

    @Test
    public void testElementaryFunctionMin() throws EvaluationException {
        String testExpression = "min(1, 7)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(1.0, result);
    }

    @Test
    public void testFunctionWithNegativeArgument() throws EvaluationException {
        String testExpression = "min(1, 7, -1)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(-1.0, result);
    }

    @Test
    public void testFunctionWithExpressionArgument() throws EvaluationException {
        String testExpression = "min(5,7,2-1)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(1.0, result);
    }

    @Test
    public void testFunctionWithExpressionArgumentInBrackets() throws EvaluationException {
        String testExpression = "min(5,7,(2-1))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(1.0, result);
    }

    @Test
    public void testFunctionWithNestedFunctionArgument() throws EvaluationException {
        String testExpression = "min(5, 7, min(3, 2))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(2.0, result);
    }

    @Test
    public void testFunctionMaxWithExpressionArgumentInBrackets() throws EvaluationException {
        String testExpression = "max(5,7,(2+6))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(8.0, result);
    }

    @Test
    public void testFunctionMaxWithNestedFunctionArgument() throws EvaluationException {
        String testExpression = "max(5,7,max(3,9))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(9.0, result);
    }

    @Test
    public void testFunctionSumWithExpressionArgumentInBrackets() throws EvaluationException {
        String testExpression = "sum(5,7,(2-1),8)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(21.0, result);
    }

    @Test
    public void testFunctionSumWithNestedFunctionArgument() throws EvaluationException {
        String testExpression = "sum(5,7,sum(3,2))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(17.0, result);
    }

    @Test
     public void testFunctionSqrt() throws EvaluationException {
        String testExpression = "sqrt(4)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(2.0, result);
    }

    @Test(expected=EvaluationException.class)
    public void testFunctionSqrtException() throws EvaluationException {
        String testExpression = "sqrt(4, 8)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
//        assertEquals(2.0, result);
    }

    @Test
    public void testFunctionSqrtMin() throws EvaluationException {
        String testExpression = "sqrt(min(174, 81, 357))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(9.0, result);
    }

    @Test
    public void testFunctionAbs() throws EvaluationException {
        String testExpression = "abs(-20)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(20.0, result);
    }

    @Test
    public void testFunctionPowPow() throws EvaluationException {
        String testExpression = "3^2^3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(6561.0, result);
    }

    @Test
            (expected = EvaluationException.class)
    public void testComma() throws EvaluationException {
        String testExpression = "1,+ 7";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
    }

    @Test
    public void testCommaInFunction() throws EvaluationException {
        String testExpression = "min(1, 7 - 9)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(-2.0, result);
    }
    @Test
    public void testCommaHard() throws EvaluationException {
        String testExpression = "max(1, 7 + min (5,-3,2))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(4.0, result);
    }

    @Test
            (expected = EvaluationException.class)
    public void testCommaHardException() throws EvaluationException {
        String testExpression = "max(1, 7 + min (5,-3,2), (5,7))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
    }

    @Test(expected = EvaluationException.class)
    public void testEmpty() throws EvaluationException {
        String testExpression = "";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(1.0, result);
    }
}
