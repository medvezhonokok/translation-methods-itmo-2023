package lab4;

import lab4.model.Grammar;
import lab4.service.CodeGeneratorService;
import lab4.utils.StringUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Generator {

    public static void main(String[] args) {
        showCalculator();
//        showLambdas();
    }

    private static void showLambdas() {
        CodeGeneratorService codeGeneratorService = new CodeGeneratorService();
        String labName = "Lab2";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("grammar/lab2.grammar"))) {
            System.out.println("======================================");
            String tokens = bufferedReader.readLine();
            String nested = bufferedReader.readLine();
            if (StringUtil.isNotNullOrBlank(nested) && nested.startsWith("#NESTED#")) {
                System.out.println("Found nested code parts...");
            } else {
                System.out.println("Not found nested code parts...");
                nested = null;
            }
            Grammar grammar = new Grammar(bufferedReader.lines().toList(), tokens, null);

            codeGeneratorService.generateTree();
            codeGeneratorService.generateTokensFile(tokens, labName);
            codeGeneratorService.generateLexer(labName, true, true);
            codeGeneratorService.generateParser(labName, grammar);

            System.out.println("Files to generated for '" + labName + "' grammar: ");
            System.out.println(" - " + labName + "Parser");
            System.out.println(" - " + labName + "Token");
            System.out.println(" - " + labName + "Lexer");
            System.out.println(" - " + "Tree");

            System.out.println("'" + labName + "' grammar is LL1: " + grammar.isLL1Grammar());
            System.out.println("======================================\n\n");
        } catch (IOException ignored) {
            // No operations.
        }
    }

    private static void showCalculator() {
        CodeGeneratorService codeGeneratorService = new CodeGeneratorService();
        String calcName = "Calc";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("grammar/calculator.grammar"))) {
            System.out.println("======================================");

            String tokens = bufferedReader.readLine();
            String nested = bufferedReader.readLine();
            if (StringUtil.isNotNullOrBlank(nested) && nested.startsWith("#NESTED#")) {
                System.out.println("Found nested code parts...");
            } else {
                System.out.println("Not found nested code parts...");
                nested = null;
            }

            Grammar grammar = new Grammar(bufferedReader.lines().toList(), tokens, nested);

            codeGeneratorService.generateTree();
            codeGeneratorService.generateTokensFile(tokens, calcName);
            codeGeneratorService.generateLexer(calcName, true, false);
            codeGeneratorService.generateParser(calcName, grammar);

            System.out.println("Files to generated for '" + calcName + "' grammar: ");
            System.out.println(" - " + calcName + "Parser");
            System.out.println(" - " + calcName + "Token");
            System.out.println(" - " + calcName + "Lexer");
            System.out.println(" - " + "Tree");

            System.out.println("'" + calcName + "' grammar is LL1: " + grammar.isLL1Grammar());
            System.out.println("======================================\n\n");
        } catch (IOException ignored) {
            // No operations.
        }
    }
}

