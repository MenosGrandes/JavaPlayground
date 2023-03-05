package mg.sort;

import mg.containers.container.MutableContainerI;
import mg.containers.container.SortableContainerI;
import mg.counter.Counter;
import mg.counter.CounterOne;

import java.util.List;

public class Sort {

    public static void sort(SortType sortType, SortableContainerI<Integer> sortable, Counter loopCounter, Counter compareCounter)
    {
        switch (sortType) {
            case BubbleSort -> Sort.bubbleSort( sortable, loopCounter, compareCounter );
            case BubbleSortOp -> Sort.bubbleSort_o1( sortable, loopCounter, compareCounter );
            case DoubleBubbleSort -> Sort.doubleBubbleSort( sortable, loopCounter, compareCounter );
            case QuickSort -> Sort.quickSortSort( sortable, loopCounter, compareCounter);
        }
    }


    private static void insertSort( SortableContainerI<Integer> arr ) {
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

    private static void bubbleSort( SortableContainerI<Integer> arr, Counter loopCounter, Counter compareCoutner ) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            loopCounter.step();
            for (int j = 0; j < n - i - 1; j++) {
                loopCounter.step();
                compareCoutner.step();
                if ( arr.get( j ) > arr.get( j + 1 ) ) {
                    swap( arr, j, j + 1 );
                }
            }
        }
    }

    private static void bubbleSort_o1( SortableContainerI<Integer> arr, Counter loopCounter, Counter compareCoutner ) {
        int n = arr.size();
        boolean isChanged = false;
        for (int i = 0; i < n; i++) {
            loopCounter.step();

            for (int j = 0; j < n - i - 1; j++) {
                loopCounter.step();
                compareCoutner.step();
                if ( arr.get( j ) > arr.get( j + 1 ) ) {
                    swap( arr, j, j + 1 );
                    isChanged = true;
                }
            }
            if ( !isChanged ) {
                break;
            }
        }
    }

    private static void doubleBubbleSort( SortableContainerI<Integer> arr, Counter loopCounter, Counter compareCounter ) {

        for (int i = 0; i < arr.size() - 1; i++)//(1)
        {
            loopCounter.step();
            int minElem = i, maxElem = i + 1;//(2)
            compareCounter.step();
            if ( arr.get( minElem ) > arr.get( maxElem ) )//(3)
            {
                swap( arr, minElem, maxElem );//(4)
            }
            while (maxElem < (arr.size() - 1) && arr.get( maxElem ) > arr.get( maxElem + 1 ))//(8) // N
            {
                loopCounter.step();

                compareCounter.step();
                compareCounter.step();

                swap( arr, maxElem, maxElem + 1 );//(4)
                maxElem++;//(10)
            }
            while (minElem > 0 && arr.get( minElem ) < arr.get( minElem - 1 ))//(5) //N
            {
                loopCounter.step();
                compareCounter.step();
                compareCounter.step();

                swap( arr, minElem, minElem - 1 );//(4)
                minElem--;//(7)1
            }

        }


    }

    private static int partition( SortableContainerI<Integer> arr, Counter loopCounter, Counter compareCounter, int begin, int end  ) {
        int pivot = arr.get( end );
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            loopCounter.step();
            if ( arr.get( j ) <= pivot ) {
                compareCounter.step();
                i++;
                    swap(arr,i,j);
            }
        }
        swap(arr,i + 1 ,end);
        return i + 1;
    }



    private static void quickSortSort(SortableContainerI<Integer> arr, Counter loopCounter, Counter compareCounter)
    {
        quickSort(arr, loopCounter,compareCounter,0,arr.size()-1);
    }
    private static void quickSort( SortableContainerI<Integer> arr, Counter loopCounter, Counter compareCounter, int begin, int end ) {
        if (begin < end) {
            int partitionIndex = partition( arr, loopCounter, compareCounter, begin, end );

            quickSort( arr, loopCounter, compareCounter, begin, partitionIndex - 1 );
            quickSort( arr, loopCounter, compareCounter, partitionIndex + 1, end );
        }

    }

    private static void swap( SortableContainerI<Integer> arr, Integer p1, Integer p2 ) {
        Integer temp = arr.get( p1 );
        arr.set( p1, arr.get( p2 ) );
        arr.set( p2, temp );
    }
}
