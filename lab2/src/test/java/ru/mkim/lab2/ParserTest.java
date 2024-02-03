package ru.mkim.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;


class ParserTest {

    private static void parse(String expression) throws ParseException {
        new Parser().parse(new ByteArrayInputStream(expression.getBytes(StandardCharsets.UTF_8)));
    }

    private static void assertNotThrows(String expression) {
        try {
            parse(expression);
        } catch (ParseException e) {
            throw new AssertionError("<<" + expression + ">> should not throw exception, "
                    + "but found: " + e.getMessage(), e);
        }
    }

    private static void assertThrows(String expression) {
        Assertions.assertThrows(ParseException.class, () -> parse(expression));
    }

    @Test
    public void test_01_IncorrectLambdaExpressions() {
        assertThrows("");
        assertThrows("lambda 1 :");
        assertThrows("lambda");
        assertThrows("lambda 3 : 10 20");
        assertThrows("lambda x, y : x y");
        assertThrows("lambda x, y : : x + y");
        assertThrows("lambda x, y : x + y(");
        assertThrows("lambda x, y : x + y +");
        assertThrows("lambda x, y, : x + y");
        assertThrows("lambda x, y : x + y :");
        assertThrows("lambda x : x + + y");
        assertThrows("lambda x, y + z : x + y + z");
        assertThrows("lambda 3 : 10 20");
        assertThrows("lambda x, y : z : x + (y + z)");
        assertThrows("lambda x : x +  + y");
        assertThrows("lambda x, y + z : x + y + z");
        assertThrows("lambda 1 : lambda x : (a + b) * 2 : lambda 2");
        assertThrows("lambda lambda : x + y + 1");
        assertThrows("lambda a, b, c ,d, e, f, g : x + y - z * ((a + b + c) * (d + e + f) * g) a + b + c + d + e + f + g");
    }

    @Test
    public void test_01_CorrectLambdaExpression() {
        assertNotThrows("lambda x : x");
        assertNotThrows("lambda x : x + 1");
        assertNotThrows("lambda x, y : x + y");
        assertNotThrows("lambda x, y : x + y + 1");
        assertNotThrows("lambda x, y : x * y");
        assertNotThrows("lambda x, y, z : x + y + z");
        assertNotThrows("lambda x, y, z : (x + y) * z");
        assertNotThrows("lambda x, y, z : x * y * z");
        assertNotThrows("lambda a : (a + 1) * 2");
        assertNotThrows("lambda a, b : (a + b) * (a - b)");
        assertNotThrows("lambda a, b : (a + b) * 2");
        assertNotThrows("lambda a, b : a * b");
        assertNotThrows("lambda x, y, z : x + y - z");
        assertNotThrows("lambda a, b, c, d, e, f, g : (a + b + c) * (d + e + f) * g");
        assertNotThrows("lambda x, y, z, a, b, c, d, e, f, g : x + y - z * ((a + b + c) * (d + e + f) * g)");
        assertNotThrows("lambda a, b, c, d, e, f, g, x, y, z : (x + y + z) - (a + b + c) * (d + e + f) * g");
    }

    @Test
    public void test_02_IncorrectInnerLambdaExpression() {
        assertThrows("lambda lambda : lambda lambda : x + y + 1");
        assertThrows("lambda 1 : lambda 2");
        assertThrows("lambda a, b : lambda x");
        assertThrows("b : lambda x: lambda x, y + z : x + y + z");
        assertThrows("lambda a, b : lambda x : (a + b) * 2 + lambda x, y, z : (x + y) * z");
        assertThrows("lambda x : lambda a, b, c, d, e, f, g : lambda y, z : (a + b + c) "
                + "* (d + e + f) * g (a + 1) * 2 - 2 * x + 3 * y + 9 * z");
        assertThrows("lambda x : lambda y : lambda z : lambda a, b, c, d, e, f, g : "
                + "lambda y, z : (a + b + c) * (d + e + f) * g (a + 1) * 2 - 2 * x + 3 * y + 9 * z");

        assertThrows("lambda x : lambda y, : x + y + 1");
        assertThrows("lambda x : lambda y, : lambda z : 2 * x + 3 * y + 9 * z");
        assertThrows("lambda x, y, z, a, b, c lambda d, e, f, g : x + y - z * ((a + b + c) * (d + e + f) * g)");
        assertThrows("lambda x : lambda y, : lambda z : lambda a : (a + 1) * 2 - 2 * x + 3 * y + 9 * z");
        assertThrows("lambda a, b, c, d, e, f, g , : lambda y : x + y + 1 * x + y + z - (a + b + c) * (d + e + f) * g");
    }

    @Test
    public void test_02_CorrectInnerLambdaExpression() {
        assertNotThrows("lambda x : lambda y : x + y + 1");
        assertNotThrows("lambda x : lambda y : lambda z : 2 * x + 3 * y + 9 * z");
        assertNotThrows("lambda x, y, z, a, b, c : lambda d, e, f, g : x + y - z * ((a + b + c) * (d + e + f) * g)");
        assertNotThrows("lambda x : lambda y : lambda z : lambda a : (a + 1) * 2 - 2 * x + 3 * y + 9 * z");
        assertNotThrows("lambda z : lambda x : lambda y : x + y + 1 * x + y + z");
        assertNotThrows("lambda a, b, c, d, e, f, g : lambda y : x + y + 1 * x + y + z - (a + b + c) * (d + e + f) * g");
    }

    @Test
    public void test_03_IncorrectLambdaExpressionWithUnaryMinus() {
        assertThrows("lambda x : -10 : -10");
        assertThrows("lambda x : lambda -y : x + 10");
        assertThrows("lambda a: lambda b : lambda c : - ");
    }

    @Test
    public void test_03_CorrectLambdaExpressionWithUnaryMinus() {
        assertNotThrows("lambda x : -10");
        assertNotThrows("lambda x : lambda y : -y");
        assertNotThrows("lambda a: lambda b : a - (-b)");
        assertNotThrows("lambda a: lambda b : -a - b");
        assertNotThrows("lambda x : --x");
        assertNotThrows("lambda a: lambda b : lambda c : -a - b - c");
    }
}