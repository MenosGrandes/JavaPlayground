package mg.sort;

import mg.containers.container.MutableContainerI;
import mg.containers.container.SortableContainerI;

import java.util.List;

public class Sort {
    public static void insertSort( SortableContainerI<Integer> arr )
    {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get( i );
            int j = i - 1;

            while (j >= 0 && arr.get( j ) > key) {
                arr.set( j + 1, arr.get( j ) );
                j = j - 1;
            }
            arr.set( j + 1, key );
        }
    }
    public static  void bubbleSort( SortableContainerI<Integer> arr )
    {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if ( arr.get( j ) > arr.get( j + 1 ) ) {

                    int temp = arr.get( j );
                    arr.set( j, arr.get( j + 1 ) );
                    arr.set( j + 1, temp );
                }
    }
}
