import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class CalculatorTest {
    @Test
    public void shortIntegerNumber() throws EvaluationException {
        String testExpression = "3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(3.0, result);
    }

    @Test
    public void longIntegerNumber() throws EvaluationException {
        String testExpression = "369";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(369.0, result);
    }

    @Test
    public void doubleNumber() throws EvaluationException {
        String testExpression = "369.96";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(369.96, result);
    }

    @Test
    public void singleAddition() throws EvaluationException {
        String testExpression = "369.96+56";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(425.96, result);
    }

    @Test
    public void multipleAddition() throws EvaluationException {
        String testExpression = "369.96+56+99.4+57.3578+2";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(584.7178, result);
    }

    @Test (expected = EvaluationException.class)
    public void testUnfinishedExpression() throws EvaluationException {
        String testExpression = "3-4-";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
    }
}
