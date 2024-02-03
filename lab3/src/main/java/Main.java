import gen.main.ExpressionLexer;
import gen.main.ExpressionParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("in1.txt");

        ExpressionLexer lexer = new ExpressionLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ExpressionParser parser = new ExpressionParser(tokens);
    }

}
