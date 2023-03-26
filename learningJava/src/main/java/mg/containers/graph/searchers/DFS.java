package mg.containers.graph.searchers;

import mg.containers.graph.struct.Graph;
import mg.containers.graph.struct.GraphNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static void search( GraphNode startPoint, GraphNode endPoint)
    {
        System.out.println("DFS SEARCH START!");

        Stack<GraphNode> visited = new Stack<>();
        boolean found = false;
        visited.add( startPoint );
        while(!found )
        {
            var currentNode = visited.pop();
            System.out.println("Looking up in elements of GraphNode number =" + currentNode.number);
            if(((GraphNode<?>) currentNode).number == endPoint.number)
            {
                System.out.println("Found element:" + ((GraphNode<?>) currentNode).number);
                found = true;
            }
            for(var e : currentNode.items )
            {
                visited.push( (GraphNode) e );
            }

            if(visited.isEmpty())
            {
                found = true;
            }

        }
        System.out.println("DFS SEARCH END!");

    }
}
