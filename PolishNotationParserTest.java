import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class PolishNotationParserTest {

    @Test
    public void testParse()
    {
        assertEquals(2.0,PolishNotationParser.parse("1 1 +"));
        assertEquals(0.0,PolishNotationParser.parse("1 1 -"));
        assertEquals(2.0,PolishNotationParser.parse("4 2 /"));
        assertEquals(14.0, PolishNotationParser.parse("5 1 2 + 4 * + 3 -"));
        assertEquals(40.0, PolishNotationParser.parse("12 2 3 4 * 10 5 / + * +"));
    }

}