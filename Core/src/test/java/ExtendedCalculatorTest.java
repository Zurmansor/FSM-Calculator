import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

public class ExtendedCalculatorTest {
    @Test
    public void testVariableOneExpression() throws EvaluationException {
        String testExpression = "a = 2 + 3;";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 5.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testVariableTwoExpression() throws EvaluationException {
        String testExpression = "a = 2 + 3; b = 4 + 6";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 5.0);
        testMap.put("b", 10.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testVariableSumOfVariableAndNumber() throws EvaluationException {
        String testExpression = "a = 2 + 3; b = a + 6";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 5.0);
        testMap.put("b", 11.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testSumOfVariables() throws EvaluationException {
        String testExpression = "a = 2 + 3; b = 6 + 1; c = a + b";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 5.0);
        testMap.put("b", 7.0);
        testMap.put("c", 12.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testDoubleVariable() throws EvaluationException {
        String testExpression = "a = 2 + 3; a = a * 2;";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 10.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testSameVariables() throws EvaluationException {
        String testExpression = "a = 2 + 3; a = a * a * a;";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 125.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionMaxVariable() throws EvaluationException {
        String testExpression = "a = 10; b = 8; max200 = max(a, b)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 10.0);
        testMap.put("b", 8.0);
        testMap.put("max200", 10.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionSqrtVariable() throws EvaluationException {
        String testExpression = "a = 4; b = 5; c = sqrt(a + b)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 4.0);
        testMap.put("b", 5.0);
        testMap.put("c", 3.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionMinVariable() throws EvaluationException {
        String testExpression = "a = 10 + 1; b = 8 + 4; c = min(a, b)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 11.0);
        testMap.put("b", 12.0);
        testMap.put("c", 11.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionAbsVariable() throws EvaluationException {
        String testExpression = "a = 10; b = 4; c = abs(a - b)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 10.0);
        testMap.put("b", 4.0);
        testMap.put("c", 6.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testFunctionOverwriteVariable() throws EvaluationException {
        String testExpression = "a = 10; a = 14; a = 6";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 10.0);
        testMap.put("a", 14.0);
        testMap.put("a", 6.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
     public void testFunctionVariable() throws EvaluationException {
        String testExpression = "a = sum(35, 12); b = min(14, 120, 39); c = max(6, 5, min(173, 12))";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("a", 47.0);
        testMap.put("b", 14.0);
        testMap.put("c", 12.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
     public void testLongVariables() throws EvaluationException {
        String testExpression = "he34kj_3fg=6*10;  HHEF34F = 20*33; j___rg4JH4g_5456 = he34kj_3fg^(HHEF34F/20)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put("he34kj_3fg", 60.0);
        testMap.put("HHEF34F", 660.0);
        testMap.put("j___rg4JH4g_5456", 4.7751966659678403E58);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test (expected = EvaluationException.class)
    public void testReservedVariableName() throws EvaluationException {
        String testExpression = "max = 2*4";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        calculator.evaluate(testExpression);
    }

    @Test (expected = EvaluationException.class)
    public void testNoVariable() throws EvaluationException {
        String testExpression = "ab = 2+2 ; 5-6";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        calculator.evaluate(testExpression);
    }
}
