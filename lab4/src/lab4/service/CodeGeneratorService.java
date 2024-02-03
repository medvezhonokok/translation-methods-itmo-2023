package lab4.service;

import lab4.model.Grammar;

import java.io.*;
import java.util.*;

public class CodeGeneratorService {
    private final Map<String, String> tokenToValueMap = new HashMap<>();
    private Map<String, String> NESTED = new HashMap<>();
    private final File GENERATED_DIRECTORY = new File("src/generated");

    public CodeGeneratorService() {
        // No operations.
    }

    public void generateTokensFile(String tokens, String prefixFileName) throws IOException {
        if (GENERATED_DIRECTORY.mkdirs()) {
            System.out.println("Created a new directory: 'generated'");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/generated/" + prefixFileName + "Token.java"));
        String className = prefixFileName.substring(0, 1).toUpperCase() + prefixFileName.substring(1);
        StringJoiner joiner = new StringJoiner(", ");
        for (String tokenAndValue : tokens.split("=-=-=")) {
            String[] parts = tokenAndValue.split("-----");

            if (parts.length != 2) {
                throw new InputMismatchException("Bad tokens declaration.");
            } else {
                tokenToValueMap.put(parts[0], parts[1]);
                joiner.add(parts[0] + "(" + parts[1] + ")");
            }
        }

        bufferedWriter.write("package generated;\npublic enum " + className + "Token {\n\t" + joiner + ";\n" +
                             "\n" +
                             "    private String tokenValue;\n" +
                             "\n" +
                             "    public void setTokenValue(String tokenValue) {\n" +
                             "        this.tokenValue = tokenValue;\n" +
                             "    }\n" +
                             "\n" +
                             "    public String getTokenValue() {\n" +
                             "        return switch (this) {\n" +
                             "            case NUMBER$, VARIABLE -> this.tokenValue;\n" +
                             "            default -> this.name();\n" +
                             "        };\n" +
                             "    }\n" +
                             "\n" +
                             "    " + className + "Token(String tokenValue) {\n" +
                             "        this.tokenValue = tokenValue;\n" +
                             "    }\n" +
                             "}\n");
        bufferedWriter.close();
    }

    public void generateLexer(String fileName, boolean needNumberToken, boolean needLambdaToken) throws IOException {
        if (GENERATED_DIRECTORY.mkdirs()) {
            System.out.println("Created a new directory: 'generated'");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/generated/" + fileName + "Lexer.java"));
        String className = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);

        bufferedWriter.write("package generated;\n" +
                             "\n" +
                             "import java.io.IOException;\n" +
                             "import java.io.InputStream;\n" +
                             "import java.text.ParseException;\n" +
                             "import java.util.function.Predicate;\n" +
                             "\n" +
                             "import static java.lang.Character.*;\n" +
                             "import static java.lang.Character.isWhitespace;\n" +
                             "\n" +
                             "public class " + className + "Lexer {\n" +
                             "\n" +
                             "    private final InputStream inputStream;\n" +
                             "    private int currentCharacter;\n" +
                             "    private " + className + "Token currentToken;\n" +
                             "    private final int ERROR_OFFSET = 1;\n" +
                             "\n" +
                             "\n" +
                             "    public " + className + "Lexer (InputStream inputStream) {\n" +
                             "        this.inputStream = inputStream;\n" +
                             "\n" +
                             "        try {\n" +
                             "            nextChar();\n" +
                             "        } catch (ParseException ignored) {\n" +
                             "            // No operations.\n" +
                             "        }\n" +
                             "    }\n" +
                             "\n" +
                             "    public InputStream getInputStream() {\n" +
                             "        return inputStream;\n" +
                             "    }\n" +
                             "\n" +
                             "    public int getCurrentCharacter() {\n" +
                             "        return currentCharacter;\n" +
                             "    }\n" +
                             "\n" +
                             "    public void setCurrentCharacter(int currentCharacter) {\n" +
                             "        this.currentCharacter = currentCharacter;\n" +
                             "    }\n" +
                             "\n" +
                             "    public " + className + "Token getCurrentToken() {\n" +
                             "        return currentToken;\n" +
                             "    }\n" +
                             "\n" +
                             "    public void setCurrentToken(" + className + "Token currentToken) {\n" +
                             "        this.currentToken = currentToken;\n" +
                             "    }\n" +
                             "\n" +
                             "    public int getERROR_OFFSET() {\n" +
                             "        return ERROR_OFFSET;\n" +
                             "    }\n" +
                             "\n" +
                             "    private void nextChar() throws ParseException {\n" +
                             "        try {\n" +
                             "            currentCharacter = inputStream.read();\n" +
                             "        } catch (IOException e) {\n" +
                             "            throw new ParseException(\"Can't read next symbol: [\" + e.getMessage() + \"]\", ERROR_OFFSET);\n" +
                             "        }\n" +
                             "    }\n" +
                             "\n" +
                             "    public void nextToken() throws ParseException {\n" +
                             "        while (isWhitespace((char) currentCharacter)) {\n" +
                             "            nextChar();\n" +
                             "        }\n" +
                             "\n");
        if (needLambdaToken) {
            bufferedWriter.write("""
                            if (Character.isLetter(currentCharacter)) {
                                currentToken = getLambdaOrVariableToken();
                                return;
                            }
                    """);
        }

        if (needNumberToken) {
            bufferedWriter.write("""
                            if (Character.isDigit(currentCharacter)) {
                                currentToken = getNumberToken();
                                return;
                            }
                    """);
        }

        bufferedWriter.write("        switch (currentCharacter) {\n");
        for (Map.Entry<String, String> tokenAndValue : tokenToValueMap.entrySet()) {
            if (tokenAndValue.getValue().length() == 3) {
                bufferedWriter.write("            case " + tokenAndValue.getValue().replace("\"", "'") + ":\n");
                bufferedWriter.write("                nextChar();\n" +
                                     "                currentToken = " + className + "Token." + tokenAndValue.getKey() + ";\n" +
                                     "                return;\n");
            }
        }

        bufferedWriter.write("            case -1:\n" +
                             "                currentToken = " + className + "Token.END;\n" +
                             "                return;\n" +
                             "            default:\n" +
                             "                throw new ParseException(\"Unexpected token: \" + (char) currentCharacter, ERROR_OFFSET);\n        }\n" +
                             "    }\n");


        if (needLambdaToken) {
            bufferedWriter.write(
                    "    private " + className + "Token getLambdaOrVariableToken() throws ParseException {\n" +
                    "        " + className + "Token token;\n" +
                    "        String tokenValueByPredicate = getTokenValueByPredicate(ch -> (isDigit(ch) || isLetter(ch)));\n" +
                    "\n" +
                    "        if (tokenValueByPredicate.equals(\"lambda\")) {\n" +
                    "            token = " + className + "Token.LAMBDA;\n" +
                    "        } else {\n" +
                    "            token = " + className + "Token.VARIABLE;\n" +
                    "            token.setTokenValue(tokenValueByPredicate);\n" +
                    "        }\n" +
                    "\n" +
                    "        return token;\n" +
                    "    }\n" +
                    "\n");
        }

        if (needNumberToken) {
            bufferedWriter.write(
                    "    private " + className + "Token getNumberToken() throws ParseException {\n" +
                    "        " + className + "Token number = " + className + "Token.NUMBER$;\n" +
                    "        number.setTokenValue(getTokenValueByPredicate(Character::isDigit));\n" +
                    "\n" +
                    "        return number;\n" +
                    "    }\n");
        }

        bufferedWriter.write("""

                    private String getTokenValueByPredicate(Predicate<Character> predicate) throws ParseException {
                        StringBuilder collector = new StringBuilder();

                        while (predicate.test((char) currentCharacter)) {
                            collector.append((char) currentCharacter);
                            nextChar();
                        }

                        return collector.toString();
                    }
                }

                """);

        bufferedWriter.close();
    }

    public void generateTree() throws IOException {

        if (GENERATED_DIRECTORY.mkdirs()) {
            System.out.println("Created a new directory: 'generated'");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/generated/Tree.java"));
        bufferedWriter.write("""
                package generated;
                                
                import java.util.ArrayList;
                import java.util.Arrays;
                import java.util.List;
                                
                public class Tree {
                    private final List<Tree> children;                                                  //  List of children.
                    private final String value;                                                         //  Value of the tree.
                    private final int treeId = this.hashCode();                                         //  Unique id of the tree.
                    public int val;
                    
                    public Tree(String value, Tree... children) {
                        this.value = value;
                        this.children = Arrays.asList(children);
                    }
                    public Tree(String value) {
                        this.value = value;
                        this.children = new ArrayList<>();
                    }
                    public List<Tree> getChildren() {
                        return children;
                    }
                    public String getValue() {
                        return value;
                    }
                    public int getTreeId() {
                        return treeId;
                    }
                    public void addChild(Tree t) {
                        children.add(t);
                    }
                    public void addChild(String value) {
                        addChild(new Tree(value));
                    }
                    private String dumpDfs() {
                        StringBuilder collector = new StringBuilder();
                        collector.append(getTreeId());
                                
                        if (value != null && !value.isBlank()) {
                            collector.append("[label=\\"").append(value).append("\\"]\\n");
                        }
                        children.forEach(kid -> {
                            collector.append(kid.dumpDfs()).append(getTreeId());
                            collector.append(" -> ");
                            collector.append(kid.getTreeId()).append(System.lineSeparator());
                        });
                        return collector.toString();
                    }
                    @Override
                    public String toString() {
                        return "digraph { " + dumpDfs() + " }";
                    }
                    public int getVal() {
                        return val;
                    }
                    public void setVal(int val) {
                        this.val = val;
                    }
                    public int getChildrenValueByName(String childName) {
                        for (Tree child : children) {
                            if (child.getValue().equals(childName)) {
                                return child.getVal();
                            }
                        }
                                
                        throw new RuntimeException("Cannot get children node value");
                    }
                }
                """);
        bufferedWriter.close();
    }

    public void generateParser(String fileName, Grammar grammar) throws IOException {
        NESTED = grammar.getNESTED();

        if (GENERATED_DIRECTORY.mkdirs()) {
            System.out.println("Created a new directory: 'generated'");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/generated/" + fileName + "Parser.java"));
        String className = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);

        bufferedWriter.write("package generated;\n\n");
        bufferedWriter.write("""
                import java.io.InputStream;
                import java.text.ParseException;
                import java.util.*;
                """);

        bufferedWriter.write("\n" +
                             "public class " + className + "Parser {\n" +
                             "    private " + className + "Lexer lexicalAnalyzer;\n" +
                             "    private static final int ERROR_OFFSET = 1;\n" +
                             "    private static final String EPSILON_SYMBOL = \"ε\";\n" +
                             "    public final Deque<Integer> deque = new ArrayDeque<>();\n");

        bufferedWriter.write("""
                    private Tree getCurrentTokenValueTree() {
                        return new Tree("'" + getCurrentToken().getTokenValue() + "'");
                    }
                """);

        bufferedWriter.write("    private void read() throws ParseException {\n" +
                             "        try {\n" +
                             "            lexicalAnalyzer.nextToken();\n" +
                             "        } catch (ParseException e) {\n" +
                             "            throw new ParseException(\"Cannot read next token, cause of: \" + e.getMessage(), ERROR_OFFSET);\n" +
                             "        }\n" +
                             "    }\n" +
                             "\n" +
                             "    private " + className + "Token getCurrentToken() {\n" +
                             "        return lexicalAnalyzer.getCurrentToken();\n" +
                             "    }\n\n" +
                             "    public Tree parse(InputStream inputStream) throws ParseException {\n" +
                             "        lexicalAnalyzer = new " + className + "Lexer(inputStream);\n" +
                             "        return S();\n" +
                             "    }\n" +
                             "\n" + getSState(grammar) +
                             "\n" + getOtherStatesByGrammar(grammar) +
                             "}\n");

        bufferedWriter.close();
    }

    private String getSState(Grammar grammar) {
        StringBuilder startMethod = new StringBuilder();

        startMethod.append("    private Tree S() throws ParseException {\n");
        String startState = grammar.getGrammar().get(0);
        String[] parts = startState.split("->");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Bad statement declaration: " + startState);
        } else {
            String s = parts[0].trim();
            startMethod.append("\t\treturn new Tree(\"S\", ").append("get").append(s).append("Tree()").append(");\n\t}");
        }

        return startMethod.toString();
    }

    private String getOtherStatesByGrammar(Grammar grammar) {
        StringBuilder collector = new StringBuilder();
        Map<String, List<List<String>>> stateToOtherStates = grammar.getStateToSubsequentState();

        for (Map.Entry<String, List<List<String>>> entry : stateToOtherStates.entrySet()) {
            if (entry.getValue().get(0).get(0).startsWith("_")) {
                createGetTreeMethodsWithSwitch(collector, entry.getKey().trim(), entry.getValue());
            } else {
                createGetTreeMethod(collector, entry.getKey().trim(), entry.getValue().get(0));
            }
        }

        return collector.toString();
    }

    private void createGetTreeMethodsWithSwitch(StringBuilder collector,
                                                String state, List<List<String>> allStates) {
        collector.append("    private Tree get").append(state).append("Tree() throws ParseException {\n")
                .append(state.endsWith("_") ? "        read();\n" : "")
                .append("        Tree result = new Tree(\"")
                .append(state).append("\");\n");

        collector.append("        switch (getCurrentToken()) {\n");

        for (List<String> states : allStates) {
            if (NESTED.get(states.get(0).substring(1)) != null) {
                collector.append("            case ").append(states.get(0).substring(1)).append(" -> {\n");
                collector.append("                ").append(NESTED.get(states.get(0).substring(1)).replaceAll("\"", "")).append("            }\n");
            } else {
                collector.append("            case ").append(states.get(0).substring(1)).append(" -> {\n")
                        .append("                result.addChild(")
                        .append("new Tree(getCurrentToken().name(), getCurrentTokenValueTree())").append(");\n");

                if (states.get(0).substring(1).endsWith("$")) {
                    collector.append("                read();\n");
                }

                for (int i = 1; i < states.size(); i++) {
                    collector.append("                result.addChild(get").append(states.get(i)).append("Tree());\n");
                }

                collector.append("            }\n");
            }
        }

        collector.append("""
                        }
                        
                        return result;
                    }
                """);

    }

    private void createGetTreeMethod(StringBuilder collector, String state, List<String> states) {
        collector.append("    private Tree get").append(state).append("Tree() throws ParseException {\n")
                .append(state.endsWith("_") ? "        read();\n" : "")
                .append("        Tree result = new Tree(\"").append(state).append("\");\n");
        for (String st : states) {
            collector.append("        result.addChild(get").append(st).append("Tree());\n");
        }

        collector.append("""
                        return result;
                    }
                """);
    }
}
