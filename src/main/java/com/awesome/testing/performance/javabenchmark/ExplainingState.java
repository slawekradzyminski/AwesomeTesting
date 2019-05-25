package com.awesome.testing.performance.javabenchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.util.concurrent.TimeUnit;

public class ExplainingState {

    @State(Scope.Thread)
    public static class PredefinedState {

        @Param({"1", "31"})
        public int a;

        @Param({"1", "31"})
        public int b;

        @Setup(Level.Trial)
        public void doForkSetup() {
            multiplicationResult = 0;
            System.out.println("\n Do Setup before each fork \n");
        }

        @Setup(Level.Iteration)
        public void doIterationSetup() {
            System.out.println("\n Do Setup before each iteration \n");
        }

        @TearDown(Level.Iteration)
        public void doIterationTeardown() {
            System.out.println("\n Do teardown after each iteration \n");
            System.gc();
        }

        public int multiplicationResult ;
    }

    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MINUTES)
    @Fork(value = 1, warmups = 0)
    @Measurement(time = 1, iterations = 3)
    @Benchmark
    public void testMethod(PredefinedState predefinedState) {
        predefinedState.multiplicationResult = predefinedState.a * predefinedState.b;
    }
}

