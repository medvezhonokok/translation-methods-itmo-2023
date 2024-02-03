package lab4;

import generated.CalcParser;
//import generated.Lab2Parser;
//import generated.Tree;
import generated.Tree;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.*;
import java.text.ParseException;

public class BaseTester {
    public static void main(String[] args) {
        testCalculator();
//        testLambdas();
    }

//    private static void testLambdas() {
//        File file = new File("lab2_graph.txt");
//        Tree tree;
//
//        try {
//            Lab2Parser parser = new Lab2Parser();
//            tree = parser.parse(new FileInputStream("input/input_lab2.txt"));
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//                writer.write(tree.toString());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            Graphviz.fromFile(file).render(Format.PNG).toFile(new File("lab2_graph.png"));
//        } catch (ParseException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private static void testCalculator() {
        File file = new File("calculator_graph.txt");
        Tree tree;

        try {
            CalcParser parser = new CalcParser();
            tree = parser.parse(new FileInputStream("input/input_calculator.txt"));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(tree.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Evaluated parser result is: " + parser.deque);
            Graphviz.fromFile(file).render(Format.PNG).toFile(new File("calculator_graph.png"));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
