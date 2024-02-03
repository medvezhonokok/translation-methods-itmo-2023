package generated;

import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

public class CalcParser {
    private CalcLexer lexicalAnalyzer;
    private static final int ERROR_OFFSET = 1;
    private static final String EPSILON_SYMBOL = "ε";
    public final Deque<Integer> deque = new ArrayDeque<>();

    private Tree getCurrentTokenValueTree() {
        return new Tree("'" + getCurrentToken().getTokenValue() + "'");
    }

    private void read() throws ParseException {
        try {
            lexicalAnalyzer.nextToken();
        } catch (ParseException e) {
            throw new ParseException("Cannot read next token, cause of: " + e.getMessage(), ERROR_OFFSET);
        }
    }

    private CalcToken getCurrentToken() {
        return lexicalAnalyzer.getCurrentToken();
    }

    public Tree parse(InputStream inputStream) throws ParseException {
        lexicalAnalyzer = new CalcLexer(inputStream);
        return S();
    }

    private Tree S() throws ParseException {
        return new Tree("S", getETree());
    }

    private Tree getTPrimeTree() throws ParseException {
        Tree result = new Tree("TPrime");
        switch (getCurrentToken()) {
            case MULTIPLY$ -> {
                int x = deque.pollLast();
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                read();
                result.addChild(getFTree());
                int y = deque.pollLast();
                deque.add(x * y);
            }
            case END -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
            }
        }

        return result;
    }

    private Tree getT_Tree() throws ParseException {
        read();
        Tree result = new Tree("T_");
        result.addChild(getFTree());
        result.addChild(getTPrimeTree());
        return result;
    }

    private Tree getClosingBracket_Tree() throws ParseException {
        read();
        Tree result = new Tree("ClosingBracket_");
        switch (getCurrentToken()) {
            case RPAREN -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
            }
        }

        return result;
    }

    private Tree getFTree() throws ParseException {
        Tree result = new Tree("F");
        switch (getCurrentToken()) {
            case LPAREN -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                result.addChild(getETree());
                result.addChild(getClosingBracket_Tree());
            }
            case NUMBER$ -> {
                deque.add(Integer.parseInt(getCurrentToken().getTokenValue()));
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                read();
            }
            case OP_CORN_BR -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                result.addChild(getNumbersTree());
                result.addChild(getCCBRTree());
            }
        }

        return result;
    }

    private Tree getETree() throws ParseException {
        Tree result = new Tree("E");
        result.addChild(getT_Tree());
        result.addChild(getEPrimeTree());
        return result;
    }

    private Tree getEPrimeTree() throws ParseException {
        Tree result = new Tree("EPrime");
        switch (getCurrentToken()) {
            case END -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
            }
            case PLUS -> {
                int x = deque.pollLast();
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                result.addChild(getT_Tree());
                int y = deque.pollLast();
                deque.add(x + y);
                result.addChild(getEPrimeTree());
            }
            case MINUS -> {
                int x = deque.pollLast();
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                result.addChild(getT_Tree());
                int y = deque.pollLast();
                deque.add(x - y);
                result.addChild(getEPrimeTree());
            }
        }

        return result;
    }

    private Tree getCCBRTree() throws ParseException {
        Tree result = new Tree("CCBR");
        switch (getCurrentToken()) {
            case CLOSE_CORN_BR -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
            }
        }

        return result;
    }

    private Tree getNumbersTree() throws ParseException {
        read();
        Tree result = new Tree("Numbers");
        switch (getCurrentToken()) {
            case END -> {
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
            }
            case CLOSE_CORN_BR -> {
                List<Integer> lst = new ArrayList<>(deque);
                deque.clear();
                deque.add(lst.size() % 2 == 0 ? lst.get(lst.size() / 2) : lst.get((lst.size() + 1) / 2));
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
            }
            case NUMBER$ -> {
                deque.add(Integer.parseInt(getCurrentToken().getTokenValue()));
                result.addChild(new Tree(getCurrentToken().name(), getCurrentTokenValueTree()));
                result.addChild(getNumbersTree());
                read();
            }
        }

        return result;
    }
}
