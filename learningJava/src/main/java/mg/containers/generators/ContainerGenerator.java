package mg.containers.generators;

import mg.containers.array.Array;
import mg.containers.container.SortableContainerI;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
public class ContainerGenerator<T> {
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
