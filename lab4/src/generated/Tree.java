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
            collector.append("[label=\"").append(value).append("\"]\n");
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
