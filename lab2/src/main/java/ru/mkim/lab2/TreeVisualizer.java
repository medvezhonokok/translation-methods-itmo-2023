package ru.mkim.lab2;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.*;
import java.text.ParseException;

public class TreeVisualizer {

    public static void main(String[] args) {
        File file = new File("graph.txt");
        Tree tree;

        try {
            tree = new Parser().parse(new FileInputStream("in.txt"));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(tree.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Graphviz.fromFile(file).render(Format.PNG).toFile(new File("graph.png"));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
