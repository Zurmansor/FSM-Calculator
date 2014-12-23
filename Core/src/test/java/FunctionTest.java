import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

public class FunctionTest {

    @Test
    public void testElementaryFunctionMin() throws EvaluationException {
        String testExpression = "min(1, 7)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 1.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionWithNegativeArgument() throws EvaluationException {
        String testExpression = "min(1, 7, -1)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, -1.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionWithExpressionArgument() throws EvaluationException {
        String testExpression = "min(5,7,2-1)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 1.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionWithExpressionArgumentInBrackets() throws EvaluationException {
        String testExpression = "min(5,7,(2-1))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 1.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionWithNestedFunctionArgument() throws EvaluationException {
        String testExpression = "min(5, 7, min(3, 2))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 2.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionMaxWithExpressionArgumentInBrackets() throws EvaluationException {
        String testExpression = "max(5,7,(2+6))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 8.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionMaxWithNestedFunctionArgument() throws EvaluationException {
        String testExpression = "max(5,7,max(3,9))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 9.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionSumWithExpressionArgumentInBrackets() throws EvaluationException {
        String testExpression = "sum(5,7,(2-1),8)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 21.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionSumWithNestedFunctionArgument() throws EvaluationException {
        String testExpression = "sum(5,7,sum(3,2))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 17.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
     public void testFunctionSqrt() throws EvaluationException {
        String testExpression = "sqrt(4)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 2.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test(expected=EvaluationException.class)
    public void testFunctionSqrtException() throws EvaluationException {
        String testExpression = "sqrt(4, 8)";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test(expected=EvaluationException.class)
    public void testFunctionNegativeArgumentSqrt() throws EvaluationException {
        String testExpression = "sqrt(-9)";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test
    public void testFunctionSqrtOfSqrt() throws EvaluationException {
        String testExpression = "sqrt(sqrt(81))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 3.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionAbs() throws EvaluationException {
        String testExpression = "abs(-20)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 20.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test(expected=EvaluationException.class)
    public void testFunctionAbsException() throws EvaluationException {
        String testExpression = "abs(14, -8)";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test
    public void testFunctionPowPow() throws EvaluationException {
        String testExpression = "3^2^3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 6561.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test(expected = EvaluationException.class)
    public void testComma() throws EvaluationException {
        String testExpression = "1,+ 7";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test
    public void testCommaInFunction() throws EvaluationException {
        String testExpression = "min(1, 7 - 9)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, -2.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test(expected = EvaluationException.class)
    public void testEmpty() throws EvaluationException {
        String testExpression = "";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 1.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }


}
