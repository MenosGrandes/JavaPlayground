package mg.containers;

import mg.containers.array.Array;
import mg.containers.bag.Bag;
import mg.containers.linked_list.LinkedList;

public class Run {
    public static void main( String[] args ) {

        Bag<Integer> a = new Bag<>(new Array() );
        for(var i = 0; i < 100;i++)
        {
            a.add(i);
        }
        for(var c : a)
        {
            System.out.print(c + " ");
        }
        System.out.println("LINKED LIST!");

        Bag<Integer> bg= new Bag<>(new LinkedList());
        for(var i = 0; i < 100;i++)
        {
            bg.add(i);
        }

        for(var c : bg)
        {
            System.out.print(c + " ");

        }
        System.out.println(a.isEmpty());
    }

}
