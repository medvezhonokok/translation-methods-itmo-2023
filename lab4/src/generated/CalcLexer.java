package generated;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.function.Predicate;

import static java.lang.Character.*;
import static java.lang.Character.isWhitespace;

public class CalcLexer {

    private final InputStream inputStream;
    private int currentCharacter;
    private CalcToken currentToken;
    private final int ERROR_OFFSET = 1;


    public CalcLexer (InputStream inputStream) {
        this.inputStream = inputStream;

        try {
            nextChar();
        } catch (ParseException ignored) {
            // No operations.
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public int getCurrentCharacter() {
        return currentCharacter;
    }

    public void setCurrentCharacter(int currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    public CalcToken getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(CalcToken currentToken) {
        this.currentToken = currentToken;
    }

    public int getERROR_OFFSET() {
        return ERROR_OFFSET;
    }

    private void nextChar() throws ParseException {
        try {
            currentCharacter = inputStream.read();
        } catch (IOException e) {
            throw new ParseException("Can't read next symbol: [" + e.getMessage() + "]", ERROR_OFFSET);
        }
    }

    public void nextToken() throws ParseException {
        while (isWhitespace((char) currentCharacter)) {
            nextChar();
        }

        if (Character.isDigit(currentCharacter)) {
            currentToken = getNumberToken();
            return;
        }
        switch (currentCharacter) {
            case '*':
                nextChar();
                currentToken = CalcToken.MULTIPLY$;
                return;
            case '>':
                nextChar();
                currentToken = CalcToken.CLOSE_CORN_BR;
                return;
            case '(':
                nextChar();
                currentToken = CalcToken.LPAREN;
                return;
            case ')':
                nextChar();
                currentToken = CalcToken.RPAREN;
                return;
            case '<':
                nextChar();
                currentToken = CalcToken.OP_CORN_BR;
                return;
            case '+':
                nextChar();
                currentToken = CalcToken.PLUS;
                return;
            case '-':
                nextChar();
                currentToken = CalcToken.MINUS;
                return;
            case '/':
                nextChar();
                currentToken = CalcToken.DIVIDE;
                return;
            case -1:
                currentToken = CalcToken.END;
                return;
            default:
                throw new ParseException("Unexpected token: " + (char) currentCharacter, ERROR_OFFSET);
        }
    }
    private CalcToken getNumberToken() throws ParseException {
        CalcToken number = CalcToken.NUMBER$;
        number.setTokenValue(getTokenValueByPredicate(Character::isDigit));

        return number;
    }

    private String getTokenValueByPredicate(Predicate<Character> predicate) throws ParseException {
        StringBuilder collector = new StringBuilder();

        while (predicate.test((char) currentCharacter)) {
            collector.append((char) currentCharacter);
            nextChar();
        }

        return collector.toString();
    }
}

