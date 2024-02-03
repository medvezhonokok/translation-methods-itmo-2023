package ru.mkim.lab2;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.function.Predicate;

import static java.lang.Character.*;
import static java.lang.Character.isWhitespace;

public class LexicalAnalyzer {

    private final InputStream inputStream;
    private int currentCharacter;
    @Getter
    private Token currentToken;
    private final int ERROR_OFFSET = 1;

    public LexicalAnalyzer(InputStream inputStream) {
        this.inputStream = inputStream;

        try {
            nextChar();
        } catch (ParseException ignored) {
            // No operations.
        }
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

        if (Character.isLetter(currentCharacter)) {
            currentToken = getLambdaOrVariableToken();
        }

        if (Character.isDigit(currentCharacter)) {
            currentToken = getNumberToken();
        }

        if (currentCharacter == ':') {
            nextChar();
            currentToken = Token.COLON;
        } else if (currentCharacter == ',') {
            nextChar();
            currentToken = Token.COMMA;
        } else if (currentCharacter == '+') {
            nextChar();
            currentToken = Token.PLUS;
        } else if (currentCharacter == '-') {
            nextChar();
            currentToken = Token.MINUS;
        } else if (currentCharacter == '*') {
            nextChar();
            currentToken = Token.MULTI;
        } else if (currentCharacter == '(') {
            nextChar();
            currentToken = Token.LPAREN;
        } else if (currentCharacter == ')') {
            nextChar();
            currentToken = Token.RPAREN;
        } else if (currentCharacter == -1) {
            currentToken = Token.END;
        } else {
            throw new ParseException("Unexpected token: " + (char) currentCharacter, ERROR_OFFSET);
        }
    }

    private Token getLambdaOrVariableToken() throws ParseException {
        Token token;
        String tokenValueByPredicate = getTokenValueByPredicate(ch -> (isDigit(ch) || isLetter(ch)));

        if (tokenValueByPredicate.equals("lambda")) {
            token = Token.LAMBDA;
        } else {
            token = Token.VARIABLE;
            token.setTokenValue(tokenValueByPredicate);
        }

        return token;
    }

    private Token getNumberToken() throws ParseException {
        Token number = Token.NUMBER;
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
