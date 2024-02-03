package ru.mkim.lab2;

import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    private LexicalAnalyzer lexicalAnalyzer;
    private static final int ERROR_OFFSET = 1;
    private static final String EPSILON_SYMBOL = "ε";

    private Tree S() throws ParseException {
        return new Tree("S", getLambdasTree(true), getExpressionTree());
    }

    private Tree getLambdasTree(boolean needToRead) throws ParseException {
        return new Tree("Lambdas", getInnerLambdasTree(needToRead), getLambdasPrimeTree());
    }

    private Tree getInnerLambdasTree(boolean needToRead) throws ParseException {
        Tree innerLambdas = new Tree("InnerLambdas");

        if (needToRead) {
            read();
        }

        if (getCurrentToken() == Token.LAMBDA) {
            innerLambdas.addChild("lambda");
            innerLambdas.addChild(getArgumentsTree());
            innerLambdas.addChild(":");
        } else {
            throw new ParseException("Unexpected token: " + getCurrentToken(), ERROR_OFFSET);
        }

        return innerLambdas;
    }

    private Tree getArgumentsTree() throws ParseException {
        Tree args = new Tree("Args");

        read();
        switch (getCurrentToken()) {
            case COMMA -> {
                read();
                if (getCurrentToken() == Token.VARIABLE) {
                    args.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                    args.addChild(getArgumentsPrimeTree());
                } else {
                    throw new ParseException("Expected token is ['VARIABLE']"
                                             + ", but found: " + getCurrentToken(), ERROR_OFFSET);
                }
            }

            case VARIABLE -> {
                args.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                args.addChild(getArgumentsPrimeTree());
            }

            case COLON -> args.addChild(EPSILON_SYMBOL);

            default -> throw new ParseException("Expected token's are ['COLON' or 'VARIABLE']"
                                                + ", but found: " + getCurrentToken(), ERROR_OFFSET);
        }

        return args;
    }

    private Tree getCurrentTokenValueTree() {
        return new Tree("'" + getCurrentToken().getTokenValue() + "'");
    }

    private Tree getArgumentsPrimeTree() throws ParseException {
        Tree argumentsPrime = new Tree("Args'");

        read();
        switch (getCurrentToken()) {
            case VARIABLE -> {
                argumentsPrime.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                argumentsPrime.addChild(getArgumentsPrimeTree());
            }

            case COMMA -> {
                argumentsPrime.addChild(",");
                read();

                if (getCurrentToken() == Token.VARIABLE) {
                    argumentsPrime.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                    argumentsPrime.addChild(getArgumentsTree());
                } else {
                    throw new ParseException("Expected token is 'VARIABLE', but found: " + getCurrentToken(), ERROR_OFFSET);
                }
            }

            case COLON -> argumentsPrime.addChild(EPSILON_SYMBOL);

            default -> throw new ParseException("Expected token's are ['VARIABLE', 'COMMA' or 'COLON']"
                                                + ", but found: " + getCurrentToken(), ERROR_OFFSET);
        }

        return argumentsPrime;
    }

    private Tree getExpressionTree() throws ParseException {
        Tree expression = new Tree("Expression");

        expression.addChild(getTTree());
        expression.addChild(getExpressionPrimeTree());

        return expression;
    }

    private Tree getExpressionPrimeTree() throws ParseException {
        Tree expressionPrime = new Tree("Expression'");

        switch (getCurrentToken()) {
            case END -> expressionPrime.addChild(EPSILON_SYMBOL);

            case PLUS -> {
                read();
                expressionPrime.addChild(new Tree("PLUS", new Tree("+")));
                expressionPrime.addChild(getTTree());
                expressionPrime.addChild(getExpressionPrimeTree());
            }

            case MINUS -> {
                read();
                expressionPrime.addChild(new Tree("MINUS", new Tree("-")));
                expressionPrime.addChild(getTTree());
                expressionPrime.addChild(getExpressionPrimeTree());
            }

            case RPAREN -> {
                expressionPrime.addChild(EPSILON_SYMBOL);
                return expressionPrime;
            }

            default -> throw new ParseException("Expected token's are ['MINUS', 'PLUS' or 'END']"
                                                + ", but found: " + getCurrentToken(), ERROR_OFFSET);
        }

        return expressionPrime;
    }

    private Token getCurrentToken() {
        return lexicalAnalyzer.getCurrentToken();
    }

    private Tree getLambdasPrimeTree() throws ParseException {
        Tree lambdasPrime = new Tree("Lambdas'");

        read();
        if (getCurrentToken() == Token.LAMBDA) {
            lambdasPrime.addChild(getLambdasTree(false));
        } else {
            lambdasPrime.addChild(EPSILON_SYMBOL);
        }

        return lambdasPrime;
    }

    private Tree getTTree() throws ParseException {
        Tree t = new Tree("T");

        t.addChild(F());
        t.addChild(TPrime());

        return t;
    }

    private Tree TPrime() throws ParseException {
        Tree tPrime = new Tree("T'");

        switch (getCurrentToken()) {
            case MULTI -> {
                tPrime.addChild("MULTI");
                read();
                tPrime.addChild(F());
                tPrime.addChild(TPrime());
            }

            case END -> tPrime.addChild(EPSILON_SYMBOL);
        }

        return tPrime;
    }

    private Tree F() throws ParseException {
        Tree f = new Tree("F");

        switch (getCurrentToken()) {
            case MINUS -> {
                read();
                f.addChild(new Tree("UNARY_MINUS", new Tree("-")));
                f.addChild(F());
            }

            case LPAREN -> {
                f.addChild("(");
                read();
                f.addChild(getExpressionTree());
                if (getCurrentToken() == Token.RPAREN) {
                    f.addChild(")");
                    read();
                } else {
                    throw new ParseException("Unexpected token: " + getCurrentToken()
                                             + ", expected tokens are ['RPAREN']", ERROR_OFFSET);
                }
            }

            case NUMBER -> {
                f.addChild(new Tree("Number", getCurrentTokenValueTree()));
                read();
            }

            case VARIABLE -> {
                f.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                read();
            }

            default -> throw new ParseException("Unexpected token: " + getCurrentToken()
                                                + ", expected tokens are ['VARIABLE', 'NUMBER', 'LPAREN' or 'MINUS']", ERROR_OFFSET);
        }

        return f;
    }

    private void read() throws ParseException {
        try {
            lexicalAnalyzer.nextToken();
        } catch (ParseException e) {
            throw new ParseException("Cannot read next token, cause of: " + e.getMessage(), ERROR_OFFSET);
        }
    }

    public Tree parse(InputStream inputStream) throws ParseException {
        lexicalAnalyzer = new LexicalAnalyzer(inputStream);
        return S();
    }
}