package com.spring.boot.study.jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadCalculator implements Calculator {
    private final int threadNum;

    private final ExecutorService executorService;

    public MultiThreadCalculator(int threadNum) {
        this.threadNum = threadNum;
        this.executorService = Executors.newFixedThreadPool(threadNum);
    }

    private class SumTask implements Callable<Long> {
        private int[] numbers;

        private int from;

        private int to;

        public SumTask(int[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        public Long call() throws Exception {
            long total = 0L;
            for (int i = from; i < to; i++) {
                total += numbers[i];
            }
            return total;
        }
    }

    public long sum(int[] numbers) {
        int chunk = numbers.length / threadNum;

        int from, to;
        List<SumTask> tasks = new ArrayList<SumTask>();
        for (int i = 1; i <= threadNum; i++) {
            if (i == threadNum) {
                from = (i - 1) * chunk;
                to = numbers.length;
            } else {
                from = (i - 1) * chunk;
                to = i * chunk;
            }
            tasks.add(new SumTask(numbers, from, to));
        }

        try {
            List<Future<Long>> futures = executorService.invokeAll(tasks);

            long total = 0L;
            for (Future<Long> future : futures) {
                total += future.get();
            }
            return total;
        } catch (Exception e) {
            // ignore
            return 0;
        }
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}