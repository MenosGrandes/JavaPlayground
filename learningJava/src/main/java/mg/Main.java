package mg;

import mg.containers.array.Array;
import mg.containers.generators.ContainerGenerator;
import mg.counter.CounterOne;
import mg.counter.factory.Counters;
import mg.sort.IsSorted;
import mg.sort.Sort;
import mg.sort.SortType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void runSortComaprision( SortType sortType, Integer samples, Integer minN, Integer maxN ) throws IOException {
        System.out.println("START!!");

        FileWriter fileWriter = new FileWriter(sortType.name() + "_" + samples + "_" + minN + "_" + maxN);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%-15s",sortType.name());
        printWriter.println("");
        printWriter.printf("|%-64s | %-64s| %-64s |","avarageCompares", "avarageLoops", "sizeOfVector");
        printWriter.println("");
        var floor =  new String(new char[64]).replace("\0", "-");
        printWriter.printf("|%-64s | %-64s| %-64s|",floor, floor,floor);

        printWriter.println("");

        for (int i = minN; i < maxN; i++) {
            var x = (int) Math.pow( 2, i );
            var avarageLoops = 0l;
            var avarageCompares = 0l;
            for (int s = 0; s < samples; s++) {
                CounterOne loopCounter = Counters.longStartFrom0();
                CounterOne compareCounter = Counters.longStartFrom0();

                Array<Integer> sortable = (Array<Integer>) ContainerGenerator.generateRandomArray( x );

                switch (sortType) {
                    case BubbleSort -> Sort.bubbleSort( sortable, loopCounter, compareCounter );
                    case BubbleSortOp -> Sort.bubbleSort_o1( sortable, loopCounter, compareCounter );
                    case DoubleBubbleSort -> Sort.doubleBubbleSort( sortable, loopCounter, compareCounter );

                }

                var b = IsSorted.isIt( sortable );
                if ( !b ) {
                    System.out.println( "NOT SORTED!" );
                    break;
                }
                avarageLoops += (long) loopCounter.getValue();
                avarageCompares += (long) compareCounter.getValue();

            }
            avarageCompares /= samples;
            avarageLoops /= samples;


            printWriter.printf("|%-64d | %-64d| %-64d|", avarageCompares, avarageLoops, x);
        }
        System.out.println("DON!");
        printWriter.close();
    }

    public static void main( String[] args ) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute( () -> {
            try {
                runSortComaprision( SortType.BubbleSort, 2, 10, 11 );
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
        } );
        executor.execute( () -> {
            try {
                runSortComaprision( SortType.BubbleSortOp, 2, 10, 12 );
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
        } );

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        //runSortComaprision( SortType.BubbleSortOp, 5, 10, 20 );
        //runSortComaprision( SortType.DoubleBubbleSort, 5, 10, 20 );

    }
}