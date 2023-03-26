package mg.containers.graph.searchers;

import mg.containers.graph.struct.Graph;
import mg.containers.graph.struct.GraphNode;

import java.util.*;

public class BFS {

    public static void search( GraphNode startPoint, GraphNode endPoint)
    {
        System.out.println("BFS SEARCH START!");
        Queue<GraphNode> visited = new LinkedList<GraphNode>();
        boolean found = false;
        visited.add( startPoint );
        while(!found )
        {
            var currentNode = visited.poll();
            System.out.println("Looking up in elements of GraphNode number =" + currentNode.number);
            if(((GraphNode<?>) currentNode).number == endPoint.number)
            {
                System.out.println("Found element:" + ((GraphNode<?>) currentNode).number);
                found = true;
            }
            for(var e : currentNode.items )
            {
                visited.add( (GraphNode) e );
            }

            if(visited.isEmpty())
            {
                found = true;
            }

        }
        System.out.println("BFS SEARCH! END");

    }
}
