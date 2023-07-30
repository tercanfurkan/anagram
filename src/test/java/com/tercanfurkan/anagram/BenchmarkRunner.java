package com.tercanfurkan.anagram;

import com.tercanfurkan.anagram.processor.HashedAnagramProcessor;
import com.tercanfurkan.anagram.processor.SortedAnagramProcessor;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Measurement(time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Warmup(time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
public class BenchmarkRunner {

    public static void main(String[] args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }

    private static final String ANAGRAM_1 = "abcdefghijk XYZ 1234".repeat(10000);

    private static final String ANAGRAM_2 = "XYZ 1234, abcdefghijk".repeat(10000);

    @Benchmark
    public void benchmarkSortedAnagramProcessor() {
        new SortedAnagramProcessor().areAnagrams(List.of(ANAGRAM_1, ANAGRAM_2));
    }

    @Benchmark
    public void benchmarkHashedAnagramProcessor() {
        new HashedAnagramProcessor().areAnagrams(List.of(ANAGRAM_1, ANAGRAM_2));
    }
}
