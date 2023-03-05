package mg.containers;

import mg.containers.array.Array;
import mg.containers.bag.Bag;
import mg.containers.generators.ContainerGenerator;
import mg.containers.linked_list.LinkedList;

import java.util.ArrayList;

public class Run {
    public static void main( String[] args ) {


/*
        ContainerGenerator cg = new ContainerGenerator();
        var array = cg.generateArray( 3000 );

        for(var i : array)
        {
            System.out.print(i + " ");
        }*/


    ArrayList a = new ArrayList();

        Array<Integer> ai = new Array<>();
        for(int i = 0 ; i <256;i++)
        {
            ai.add( i );
            System.out.print(i + " ");
        }


    }
}
