
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

public class BinaryOperatorTest {

    @Test
    public void testMinusBinaryOperator() throws EvaluationException {
        String testExpression = "9-3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 6.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testPlusBinaryOperator() throws EvaluationException {
        String testExpression = "3+9";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 12.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
         public void testDivideBinaryOperator() throws EvaluationException {
        String testExpression = "9/3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 3.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
         public void testMultiplyBinaryOperator() throws EvaluationException {
        String testExpression = "9*4";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 36.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
         public void testPowerBinaryOperator() throws EvaluationException {
        String testExpression = "3^3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 27.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
         public void testPrioritiesBinaryOperators() throws EvaluationException {
        String testExpression = "5+4*2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 13.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
         public void testPrioritiesBinaryOperatorsWithPower() throws EvaluationException {
        String testExpression = "5+4*3^2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 41.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test
    public void testBinaryOperationOfFunctions() throws EvaluationException {
        String testExpression = "min(5,7)+min(8,2)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        HashMap<String, Double> testMap = new HashMap<String, Double>();
        testMap.put(null, 7.0);

        final HashMap<String, Double> result = calculator.evaluate(testExpression);
        assertEquals(testMap, result);
    }

    @Test (expected=EvaluationException.class)
    public void testDivideBinaryOperatorByZero() throws EvaluationException {
        String testExpression = "9/0";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

    @Test (expected=EvaluationException.class)
    public void testComplexExpressionDivideBinaryOperatorByZero() throws EvaluationException {
        String testExpression = "max(5, 3, 10) / min(32,0,12,1,2)";
        final StateMachineCalculator calculator = new StateMachineCalculator();
        calculator.evaluate(testExpression);
    }

}


