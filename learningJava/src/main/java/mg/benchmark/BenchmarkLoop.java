
package mg.benchmark;

import mg.sort.Sort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2)
//@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class BenchmarkLoop {


    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"100", "500", "1000","10000","100000","1000000"})
        public int listSize;

        public List<Integer> testList;

        @Setup(Level.Trial)
        public void setUp() {
            testList = new Random()
                    .ints()
                    .limit(listSize)
                    .boxed()
                    .collect(Collectors.toList());
        }
    }


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    void bubbleSort( List<Integer> arr )
    {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if ( arr.get( j ) > arr.get( j + 1 ) ) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get( j );
                    arr.set( j, arr.get( j + 1 ) );
                    arr.set( j + 1, temp );
                }
    }
    void insertSort( List<Integer> arr )
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

    @Benchmark
    @Threads(Threads.MAX)
    public void bubbleSortB(BenchmarkState state) {
        Sort.bubbleSort(state.testList);
    }
    @Benchmark
    @Threads(Threads.MAX)
    public void insertSortB(BenchmarkState state) {
        Sort.insertSort(state.testList);
    }
}