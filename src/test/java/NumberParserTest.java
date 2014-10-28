import com.teamdev.calculator.impl.EvaluationCommand;
import com.teamdev.calculator.impl.EvaluationContext;
import com.teamdev.calculator.impl.EvaluationService;
import com.teamdev.calculator.impl.MathExpressionParser;
import com.teamdev.calculator.impl.parser.NumberParser;
import org.junit.Test;
import static junit.framework.Assert.*;

public class NumberParserTest {
    @Test
    public void testNull() throws Exception {
        MathExpressionParser numberParse = new NumberParser();

        String testString = "h200";
        EvaluationContext context = new EvaluationContext(testString);
        EvaluationCommand result = numberParse.parse(context);

        assertNull(result);
    }

    @Test
    public void testNotNull() throws Exception {
        MathExpressionParser numberParse = new NumberParser();

        String testString = "200";
        EvaluationContext context = new EvaluationContext(testString);
        EvaluationCommand result = numberParse.parse(context);

        assertNotNull(result);
    }
}
