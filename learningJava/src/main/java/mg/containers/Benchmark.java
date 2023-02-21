
package mg.containers;

import mg.containers.bag.Bag;
import mg.containers.bag.BagArray;
import mg.containers.bag.BagNode;
import mg.sort.Sort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
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
@Warmup(iterations = 2)
@Measurement(iterations = 1)
public class Benchmark {


    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"100", "500"})
        public int listSize;
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
    public void bagArray(BenchmarkState plan, Blackhole bh) {
        BagArray<Integer> ba = new BagArray<>();
       for(var i = 0 ; i < plan.listSize;i++)
       {
            ba.add(i);
       }
        bh.consume(ba);
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(Threads.MAX)
    public void bagNode(BenchmarkState plan, Blackhole bh) {
        BagNode<Integer> ba = new BagNode<>();
        for(var i = 0 ; i < plan.listSize;i++)
        {
            ba.add(i);
        }
        bh.consume(ba);
    }
}