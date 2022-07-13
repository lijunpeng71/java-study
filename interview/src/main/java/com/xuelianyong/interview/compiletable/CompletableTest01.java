package com.xuelianyong.interview.compiletable;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-13 20:03
 **/
public class CompletableTest01 {
    public static void main(String[] args) {
        ExecutorService executorService = ThreadUtil.newExecutor(1);
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("runAsync"), executorService);
        System.out.println(runFuture.join());
        CompletableFuture<String> supplyFuture=CompletableFuture.supplyAsync(()-> {
            System.out.println("supplyAsync");
            return "supplyAsync";
        });
        System.out.println(supplyFuture.join());
        executorService.shutdown();
    }
}
