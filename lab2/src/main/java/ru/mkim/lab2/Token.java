package ru.mkim.lab2;

public enum Token {
    LAMBDA("lambda"),                                                       //  key 'lambda' word.
    COLON(":"), COMMA(","),                                       //  Delimiters.
    PLUS("+"), MINUS("-"), MULTI("*"),                  //  Binary operations.
    LPAREN("("), RPAREN(")"),                                     //  Brackets.
    VARIABLE(""), NUMBER(""),                                     //  Variable's name and numbers.
    END("$");                                                               //  End of input.

    private String tokenValue;

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getTokenValue() {
        return switch (this) {
            case NUMBER, VARIABLE -> this.tokenValue;
            default -> this.name();
        };
    }

    Token(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}

