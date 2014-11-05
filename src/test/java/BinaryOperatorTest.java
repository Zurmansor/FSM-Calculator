import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.StateMachineCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BinaryOperatorTest {

    @Test
    public void testMinusBinaryOperator() throws EvaluationException {
        String testExpression = "9-3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(6.00, result);
    }

    @Test
    public void testPlusBinaryOperator() throws EvaluationException {
        String testExpression = "3+9";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(12.00, result);
    }

    @Test
         public void testDivideBinaryOperator() throws EvaluationException {
        String testExpression = "9/3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(3.00, result);
    }

    @Test
         public void testMultiplyBinaryOperator() throws EvaluationException {
        String testExpression = "9*4";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(36.00, result);
    }

    @Test
         public void testPowerBinaryOperator() throws EvaluationException {
        String testExpression = "3^3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(27.00, result);
    }

    @Test
         public void testPrioritiesBinaryOperators() throws EvaluationException {
        String testExpression = "5+4*2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(13.00, result);
    }

    @Test
         public void testPrioritiesBinaryOperatorsWithPower() throws EvaluationException {
        String testExpression = "5+4*3^2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(41.00, result);
    }

    @Test
    public void testBinaryOperationOfFunctions() throws EvaluationException {
        String testExpression = "min(5,7)+min(8,2)";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(7.0, result);
    }
}
