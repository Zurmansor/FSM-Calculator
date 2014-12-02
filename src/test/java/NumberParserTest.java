import com.teamdev.calculator.impl.EvaluationCommand;
import com.teamdev.calculator.impl.EvaluationContext;
import com.teamdev.calculator.impl.MathExpressionParser;
import com.teamdev.calculator.impl.parser.NumberParser;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.Assert.*;

public class NumberParserTest {
    @Test
    @Ignore
    public void testNull() {
        MathExpressionParser numberParse = new NumberParser();

        String testString = "j200";
        EvaluationContext context = new EvaluationContext(testString);
//        context.setExpressionParsingIndex(1);
        EvaluationCommand result = numberParse.parse(context);

        assertNull(result);
    }

    @Test
    @Ignore
    public void testNotNull() {
        MathExpressionParser numberParse = new NumberParser();

        String testString = "200";
        EvaluationContext context = new EvaluationContext(testString);
        EvaluationCommand result = numberParse.parse(context);

        assertNotNull(result);
    }
}
