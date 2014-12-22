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
    public void testVariable() throws EvaluationException {
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
}
