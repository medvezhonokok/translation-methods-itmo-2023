//import generated.CalcParser;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.nio.charset.StandardCharsets;
//import java.text.ParseException;
//
//import static org.junit.Assert.assertEquals;
//
//public class CalculatorTest {
//
//    public int getParseResultFromString(String expression) {
//        try {
//            CalcParser parser = new CalcParser();
//            parser.parse(new ByteArrayInputStream(expression.getBytes(StandardCharsets.UTF_8)));
//            return parser.deque.getFirst();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void test_01_simpleExpression() {
//        assertEquals(1 - 2 - 3, getParseResultFromString("1 - 2 - 3"));
//        assertEquals(2, getParseResultFromString("1 + 1"));
//        assertEquals(0, getParseResultFromString("10 * 2 - 20"));
//        assertEquals(8, getParseResultFromString("3 + 5"));
//        assertEquals(-5, getParseResultFromString("0 - 5"));
//        assertEquals(25, getParseResultFromString("5 * 5"));
//        assertEquals(11, getParseResultFromString("6 + 5"));
//        assertEquals(30, getParseResultFromString("15 * 2"));
//        assertEquals(0, getParseResultFromString("0 + 0"));
//        assertEquals(100, getParseResultFromString("10 * 10"));
//    }
//
//    @Test
//    public void test_02_subtraction() {
//        assertEquals(5, getParseResultFromString("10 - 5"));
//        assertEquals(-3, getParseResultFromString("2 - 5"));
//        assertEquals(8, getParseResultFromString("12 - 4"));
//        assertEquals(-7, getParseResultFromString("5 - 12"));
//        assertEquals(0, getParseResultFromString("3 - 3"));
//        assertEquals(15, getParseResultFromString("20 - 5"));
//        assertEquals(-1, getParseResultFromString("3 - 4"));
//        assertEquals(2, getParseResultFromString("5 - 3"));
//        assertEquals(10, getParseResultFromString("15 - 5"));
//    }
//
//    @Test
//    public void test_03_multiplication() {
//        assertEquals(15, getParseResultFromString("3 * 5"));
//        assertEquals(0, getParseResultFromString("0 * 100"));
//        assertEquals(100, getParseResultFromString("10 * 10"));
//        assertEquals(21, getParseResultFromString("7 * 3"));
//        assertEquals(48, getParseResultFromString("8 * 6"));
//        assertEquals(0, getParseResultFromString("15 * 0"));
//    }
//
//    @Test
//    public void test_05_complexExpression() {
//        assertEquals(1 + 2 * 3, getParseResultFromString("1 + 2 * 3"));
//        assertEquals(30, getParseResultFromString("2 * (3 + 12)"));
//        assertEquals(6, getParseResultFromString("(4 - 2) * 3"));
//        assertEquals(72, getParseResultFromString("(3 + 5) * 9"));
//        assertEquals(0, getParseResultFromString("(10 - 2) * 0"));
//        assertEquals(40, getParseResultFromString("5 * (6 + 2)"));
//        assertEquals(26, getParseResultFromString("(7 * 2) + (3 * 4)"));
//        assertEquals(50, getParseResultFromString("(4 + 6) * (2 + 3)"));
//        assertEquals(15, getParseResultFromString("(3 + 5) * 2 - 1"));
//        assertEquals(50, getParseResultFromString("(5 * 2) + (8 * 5)"));
//    }
//
//    @Test
//    public void test_10_parenthesesPriority() {
//        assertEquals(24, getParseResultFromString("(3 + 5) * (2 + 1)"));
//        assertEquals(18, getParseResultFromString("3 + (5 * (2 + 1))"));
//        assertEquals(30, getParseResultFromString("(4 * 6) + (2 * 3)"));
//        assertEquals(15, getParseResultFromString("(2 + 3) * (4 - 1)"));
//        assertEquals(3, getParseResultFromString("(5 * 2) - (8 - 1)"));
//        assertEquals(45, getParseResultFromString("(3 + 2) * (8 + 1)"));
//        assertEquals(14, getParseResultFromString("(4 * 5) - (3 * 2)"));
//        assertEquals(17, getParseResultFromString("(7 * 3) - (2 * 2)"));
//        assertEquals(0, getParseResultFromString("(10 * 2) - (4 * 5)"));
//        assertEquals(4, getParseResultFromString("(5 + 3) - (2 * 2)"));
//    }
//
//}
