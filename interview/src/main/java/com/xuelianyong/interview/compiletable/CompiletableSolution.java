package com.xuelianyong.interview.compiletable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-13 13:05
 **/
public class CompiletableSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<List<CompletableFuture<Void>>> completableFutureList = CompletableFuture
                .supplyAsync(CompiletableSolution::getUserIdList)
                .thenApplyAsync(userIdList -> userIdList.stream()
                        .map(userId -> CompletableFuture
                                .supplyAsync(() -> getUserInfoById(userId))
                                .thenAccept(userInfo -> System.out.println(userInfo))
                        )
                        .collect(Collectors.toList())
                );
        mainThreadDo();
        completableFutureList.thenAccept(completableFutures ->{
            CompletableFuture<Void> completableFuture=CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
            try {
                completableFuture.thenRun(()->mainThreadDo()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).get();
        System.out.println(Thread.currentThread() + "\t" + "业务处理完毕");
    }

    public static void mainThreadDo() {
        System.out.println(Thread.currentThread() + "\t" + "主线程开始执行别的逻辑");
        sleep();
        System.out.println(Thread.currentThread() + "\t" + "主线程结束执行别的逻辑");
    }

    /**
     * 查询数据库并返回所有用户ID列表
     *
     * @return
     */
    public static List<Integer> getUserIdList() {
        sleep();
        return new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
                this.add(4);
                this.add(5);
            }
        };
    }

    public static String getUserInfoById(Integer userId) {
        System.out.println(String.format(Thread.currentThread() + "\t" + "获取用户信息开始 %d", userId));
        sleep();
        System.out.println(Thread.currentThread() + "\t" + "获取用户信息结束");
        return String.format("用户信息 %d", userId);
    }

    /**
     * 为了模拟数据库延时操作
     */
    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
