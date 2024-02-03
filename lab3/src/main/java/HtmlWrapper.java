import main.antlr4.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

// boolean a = (a && 1) || (b & c);

import java.util.Arrays;

public class HtmlWrapper extends JavaGrammarBaseListener {
    private final StringBuilder collector;
    private final String LINE_SEPARATOR = System.lineSeparator();
    private final String TAB = "\t";
    private boolean isMainClassVisited = false;
    private boolean isForStatement = false;
    private int depth = 0;

    public HtmlWrapper() {
        collector = new StringBuilder();
    }

    void appendLineSeparatorsToCollector(int count) {
        collector.append(LINE_SEPARATOR.repeat(count));
    }

    void appendToCollector(String tag, String clazz, String style, String context, int depth) {
        collector.append(TAB.repeat(depth)).append("<").append(tag).append(clazz == null ? "" : " class='" + clazz + "'").append(style == null ? "" : " style = '" + style + "'").append(" > ")
                .append(LINE_SEPARATOR);

        String[] splittedLines = context.trim().split("[\n|\r]+");

        for (String line : splittedLines) {
            collector.append(TAB.repeat(depth + 1))
                    .append(line)
                    .append(LINE_SEPARATOR);
        }

        collector.append(TAB.repeat(depth)).append("</").append(tag).append(">")
                .append(LINE_SEPARATOR);
    }

    @Override
    public void enterPackage(JavaGrammarParser.PackageContext ctx) {
        appendToCollector("p", null, null, ctx.getText(), depth);
    }

    @Override
    public void enterImports(JavaGrammarParser.ImportsContext ctx) {
        for (String s : ctx.getText().split("[\n|\r]+")) {
            appendToCollector("div", null, null, s, depth);
        }
    }

    @Override
    public void enterMain_class(JavaGrammarParser.Main_classContext ctx) {
        appendLineSeparatorsToCollector(1);
        collector.append("<div class='main_clazz' style='color: red'>").append("\n");
        depth++;
        collector.append(TAB.repeat(depth)).append(ctx.getText().split("\n+")[0]);
        depth++;
    }

    @Override
    public void exitMain_class(JavaGrammarParser.Main_classContext ctx) {
        depth = 0;
    }

    @Override
    public void enterField(JavaGrammarParser.FieldContext ctx) {
        appendLineSeparatorsToCollector(1);
        collector.append(TAB.repeat(depth + 1)).append("<div class='field' style='color: green'>").append(TAB.repeat(depth + 1)).append(
                Arrays.stream(ctx.getText().split("[\n|\r]+")).filter(s -> s != null && !s.isBlank())
                        .toArray()[0].toString().trim());
    }

    @Override
    public void exitField(JavaGrammarParser.FieldContext ctx) {
        collector.append("</div>");
    }

    @Override
    public void enterMethod(JavaGrammarParser.MethodContext ctx) {
//        appendLineSeparatorsToCollector(1);
        collector.append(TAB.repeat(depth)).append("<div class='method'>").append("\n");
        depth++;
        collector.append(TAB.repeat(depth)).append(Arrays.stream(ctx.getText().split("[\n|\r]+")).filter(
                s -> s != null && !s.isBlank()
        ).toArray()[0]).append("\n");
        depth++;
        depth++;
    }

    @Override
    public void enterFor_cycle(JavaGrammarParser.For_cycleContext ctx) {
        isForStatement = true;
//        appendLineSeparatorsToCollector(1);
        collector.append(TAB.repeat(depth)).append("<div class='for-cycle' style='color: blue'>").append("\n");
        depth++;
        Object[] forCycleContent = Arrays.stream(ctx.getText().split("[\n|\r]+")).filter(
                s -> s != null && !s.isBlank()
        ).toArray();
        collector.append(TAB.repeat(depth)).append(forCycleContent[0]).append("\n");
        depth++;
        for (int i = 1; i < forCycleContent.length - 1; i++) {
            appendToCollector("div", "for-cycle-statement", "color: grey", forCycleContent[i].toString(), depth + 1);
        }
        depth++;
        depth++;
    }

    @Override
    public void exitFor_cycle(JavaGrammarParser.For_cycleContext ctx) {
        isForStatement = false;
        depth--;
        depth--;
        collector.append(TAB.repeat(depth)).append("}").append("\n").append(TAB.repeat(depth - 1)).append("</div>");
        depth--;
    }

    @Override
    public void exitMethod(JavaGrammarParser.MethodContext ctx) {
        depth--;
        depth--;
        collector.append(TAB.repeat(depth)).append("}").append("\n").append(TAB.repeat(depth - 1)).append("</div>");
        depth--;
    }

    @Override
    public void enterStatement(JavaGrammarParser.StatementContext ctx) {
        if (!isForStatement) {
            appendToCollector("div", null, null, ctx.getText().trim(), depth);
        }
    }

    @Override
    public void enterClass(JavaGrammarParser.ClassContext ctx) {
        if (!isMainClassVisited) {
            isMainClassVisited = true;
        } else {
            depth = 0;
            appendLineSeparatorsToCollector(2);
            collector.append("<div class='inner_clazz'>").append("\n");
            depth++;
            collector.append(TAB.repeat(depth)).append(ctx.getText().split("\n+")[0]);
            depth++;
        }
    }

    @Override
    public void exitClass(JavaGrammarParser.ClassContext ctx) {
        collector.append("\n").append(TAB.repeat(1)).append("}\n</div>");
        depth = 0;
    }

    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("in1.txt");

        JavaGrammarLexer lexer = new JavaGrammarLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        JavaGrammarParser parser = new JavaGrammarParser(tokens);

        ParseTree tree = parser.start();

        HtmlWrapper htmlwrapper = new HtmlWrapper();
        ParseTreeWalker.DEFAULT.walk(htmlwrapper, tree);

        // for index
        // html
        // WS+
        //

        System.out.println(htmlwrapper.collector.toString().replaceAll("\t", "&nbsp;"));
    }
}
