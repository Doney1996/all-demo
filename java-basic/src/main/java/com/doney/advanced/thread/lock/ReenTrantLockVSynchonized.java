package com.doney.advanced.thread.lock;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * synchonized 和 ReenTrantLock 性能对比
 *
 * 基准测试模板
 *
 * https://segmentfault.com/a/1190000039902797
 */
@Measurement(iterations = 2)
@Threads(50)
@Fork(0)
@Warmup(iterations = 2, time = 5)
public class ReenTrantLockVSynchonized {
    private static Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static long cnt = 0;

    @Benchmark
    public void testWithoutLock(){
        doSomething();
    }

    @Benchmark
    public void testReentrantLock(){
        reentrantLock.lock();
        doSomething();
        reentrantLock.unlock();
    }

    @Benchmark
    public void testSynchronized(){
        synchronized (lock) {
            doSomething();
        }
    }

    private void doSomething() {
        cnt += 1;
        if (cnt >= (Long.MAX_VALUE >> 1)) {
            cnt = 0;
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(ReenTrantLockVSynchonized.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
