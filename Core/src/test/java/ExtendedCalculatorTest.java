import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExtendedCalculatorTest {
    @Test
    public void singleAddition() throws EvaluationException {
        String testExpression = "a = 2 + 3";
        final StateMachineCalculator calculator = new StateMachineCalculator();

        final double result = calculator.evaluate(testExpression);
        assertEquals(5.0, result);
    }
}
