/*
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class CalculatorTest {
    @Test
    public void testShortIntegerNumber() throws EvaluationException {
        String testExpression = "3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(3.0, result);
    }

    @Test
    public void testLongIntegerNumber() throws EvaluationException {
        String testExpression = "369";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(369.0, result);
    }

    @Test
    public void testDoubleNumber() throws EvaluationException {
        String testExpression = "369.96";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(369.96, result);
    }

    @Test
    public void testSingleAddition() throws EvaluationException {
        String testExpression = "369.96+56";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(425.96, result);
    }

    @Test
    public void testMultipleAddition() throws EvaluationException {
        String testExpression = "369.96+56+99.4+57.3578+2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(584.7178, result);
    }

//    @Test
//    public void testSkipEnter() throws EvaluationException {
//        String testExpression = "2+//n 3";
//        final StateMachineCalculator calculator = new StateMachineCalculator();
//
//        final double result = calculator.evaluate(testExpression);
//        assertEquals(5.0, result);
//    }

    @Test (expected = EvaluationException.class)
    public void testUnfinishedExpression() throws EvaluationException {
        String testExpression = "3-4-";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
    }
}
*/