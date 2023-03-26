package mg.containers;

import mg.containers.graph.searchers.BFS;
import mg.containers.graph.searchers.DFS;
import mg.containers.graph.struct.Graph;
import mg.containers.graph.struct.GraphNode;

public class Run {
    public static void main( String[] args ) {


/*
        ContainerGenerator cg = new ContainerGenerator();
        var array = cg.generateArray( 3000 );

        for(var i : array)
        {
            System.out.print(i + " ");
        }


    ArrayList a = new ArrayList();

        Array<Integer> ai = new Array<>();
        for(int i = 0 ; i <256;i++)
        {
            ai.add( i );
            System.out.print(i + " ");
        }
*/
        Graph g = new Graph();

        GraphNode root = new GraphNode(0);
        g.items.add( root );
        GraphNode gn1 = new GraphNode(1);
        GraphNode gn2 = new GraphNode(2);
        GraphNode gn3 = new GraphNode(3);
        GraphNode gn4 = new GraphNode(4);
        GraphNode gn5 = new GraphNode(5);
        GraphNode gn6 = new GraphNode(6);
        GraphNode gn7 = new GraphNode(7);
        GraphNode gn8 = new GraphNode(8);

        root.items.add( gn3 );
        root.items.add( gn4 );

        gn4.items.add(gn2);
        gn4.items.add(gn7);

        gn2.items.add(gn5);

        gn7.items.add(gn6);
        gn6.items.add(gn1);
        gn1.items.add(gn8);


        //DFS.search( root,gn8 );
       BFS.search( root,gn8 );

    }
}
