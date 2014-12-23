import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;


public class CalculatorTest {
    @Test
    public void testShortIntegerNumber() throws EvaluationException {
        String testExpression = "3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 3.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testLongIntegerNumber() throws EvaluationException {
        String testExpression = "369";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 369.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testDoubleNumber() throws EvaluationException {
        String testExpression = "369.96";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 369.96);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testSingleAddition() throws EvaluationException {
        String testExpression = "369.96+56";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 425.96);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testMultipleAddition() throws EvaluationException {
        String testExpression = "369.96+56+99.4+57.3578+2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 584.7178);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test (expected = EvaluationException.class)
    public void testUnfinishedExpression() throws EvaluationException {
        String testExpression = "3-4-";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        calculator.evaluate(testExpression);
    }
}
