package mg.containers.graph.struct;

import mg.containers.array.Array;
import mg.containers.bag.Bag;
import mg.containers.generators.ContainerGenerator;
import org.jetbrains.annotations.NotNull;

public class GraphNode<T> implements Comparable<GraphNode> {

    public GraphNode(int _number) { number = _number; items = ContainerGenerator.emptyArray();}
    public int number;
    public Array<GraphNode> items;
    @Override
    public int compareTo( @NotNull GraphNode o ) {
        return 0;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GraphNode{"+number + "}: ");
        sb.append(System.getProperty("line.separator"));
        for(var e : items)
        {
            sb.append(e);
        }
        sb.append(System.getProperty("line.separator"));

    return sb.toString();
    }

}
