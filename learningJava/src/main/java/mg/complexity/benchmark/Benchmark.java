package mg.complexity.benchmark;


import mg.complexity.Main;
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
public class Benchmark {


    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"100000","1000000","10000000","100000000"})
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
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }


    @org.openjdk.jmh.annotations.Benchmark
    @Threads(Threads.MAX)
    public void minMax_1_b(BenchmarkState state) {
     Main.minMan_1(  state.testList);

    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(Threads.MAX)
    public void minMax_2_b(BenchmarkState state) {
        Main.minMan_2(  state.testList);
    }
}