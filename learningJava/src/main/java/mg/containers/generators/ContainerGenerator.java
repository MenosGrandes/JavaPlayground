package mg.containers.generators;

import mg.containers.array.Array;
import mg.containers.bag.Bag;
import mg.containers.container.SortableContainerI;
import mg.containers.linked_list.LinkedList;

import java.util.Random;
public class ContainerGenerator<T> {
    public static <T> Bag<T> emptyArrayBag()
    {
        return new Bag<T>(new Array());
    }
    public static <T> Bag<T> emptyLinkedListBag()
    {
        return new Bag<T>(new LinkedList());
    }
    public static <T> Array<T> emptyArray()
    {
        return new Array<T>();
    }

    public static SortableContainerI<Integer> generateArray(int size)
    {
        SortableContainerI<Integer> sc = new Array<>(size);

        for(int i = 0 ; i < size ; i ++)
        {
            sc.add( i );
        }

        return sc;
    }
    public static SortableContainerI<Integer> generateRandomArray( int size)
    {
        Random rand = new Random();

        SortableContainerI<Integer> sc = new Array<>(size);

        for(int i = 0 ; i < size ; i ++)
        {
            sc.add(  rand.nextInt(10000) );
        }

        return sc;
    }
}
