package com.spring.boot.study.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("Action...Go again");
        });
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicBarrierWorker(barrier));
            t.start();
        }
    }
}

class CyclicBarrierWorker implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierWorker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Executed!");
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}