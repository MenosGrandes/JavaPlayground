
package mg.sort.benchmark;

import mg.containers.array.Array;
import mg.containers.generators.ContainerGenerator;
import mg.counter.CounterOne;
import mg.counter.factory.Counters;
import mg.sort.Sort;
import mg.sort.SortType;
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
@Measurement(iterations = 2)
public class BenchmarkLoop {


    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"10", "11", "12","13","14","15"})
        public int listSize;

        public Array<Integer> testList;
        public CounterOne loopCounter,compareCounter;
        @Setup(Level.Trial)
        public void setUp() {
            testList = (Array<Integer>) ContainerGenerator.generateRandomArray( (int) Math.pow(2, listSize) );
            loopCounter = Counters.longStartFrom0();
            compareCounter = Counters.longStartFrom0();
        }
    }


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }



    @Benchmark
    @Threads(Threads.MAX)
    public void bubbleSortB(BenchmarkState state) {
        Sort.sort( SortType.BubbleSort,state.testList,state.loopCounter, state.compareCounter);
    }
    @Benchmark
    @Threads(Threads.MAX)
    public void bubbleSortOp(BenchmarkState state) {
        Sort.sort( SortType.BubbleSortOp,state.testList,state.loopCounter, state.compareCounter);
    }
    @Benchmark
    @Threads(Threads.MAX)
    public void quickSort(BenchmarkState state) {
        Sort.sort( SortType.QuickSort,state.testList,state.loopCounter, state.compareCounter);
    }
    @Benchmark
    @Threads(Threads.MAX)
    public void doubleBubbleSort(BenchmarkState state) {
        Sort.sort( SortType.DoubleBubbleSort,state.testList,state.loopCounter, state.compareCounter);
    }
}