package mg.containers.graph.struct;

import mg.containers.array.Array;
import mg.containers.bag.Bag;
import mg.containers.generators.ContainerGenerator;

public class Graph<T> {

    public Array<GraphNode> items;
    public Graph(){
        items = ContainerGenerator.emptyArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRINTING GRAPH!:");
        sb.append(System.getProperty("line.separator"));
        sb.append("elements:");
        sb.append(System.getProperty("line.separator"));

        for(var e : items)
        {
            sb.append(e + " ");
        }
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }


}
