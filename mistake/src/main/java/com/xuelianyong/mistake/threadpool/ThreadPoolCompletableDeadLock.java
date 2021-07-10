package com.xuelianyong.mistake.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2021-07-09 21:19
 **/
public class ThreadPoolCompletableDeadLock {

    public static final ExecutorService pool = Executors.newFixedThreadPool(3, new ThreadFactory() {
        final AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("pool-thread[" + count.getAndIncrement() + "]");
            return thread;
        }
    });

    public static void main(String[] args) {
        List<CompletableFuture<Void>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CompletableFuture<Void> childFuture = CompletableFuture.runAsync(() -> {
                    System.out.println("我被执行了……");
                }, pool);
                childFuture.join();
            }, pool);
            System.out.println(String.format("第 %s 个父任务等待完成", i));
            list.add(future);
        }
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        pool.shutdown();
        System.out.println("exit");
    }

}
