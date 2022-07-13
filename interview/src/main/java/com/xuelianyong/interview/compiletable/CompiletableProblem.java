package com.xuelianyong.interview.compiletable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: java-study
 * @description: 场景： 1、从数据库中获取到用户id 2、根据用户id查询用户信息
 * @author: junpeng.li
 * @create: 2022-07-13 11:42
 **/
public class CompiletableProblem {

    private static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "\t" + "业务开始处理");
        Future<List<Integer>> userIdListFuture = threadPoolExecutor.submit(CompiletableProblem::getUserIdList);
        mainThreadDo();
        List<Integer> userIdList = userIdListFuture.get();
        List<Future<String>> userInfoFutureList = new ArrayList<>();
        userIdList.forEach(userId -> userInfoFutureList.add(threadPoolExecutor.submit(() -> getUserInfoById(userId))));
        for(int i=0;i<userInfoFutureList.size();i++){
            final String userInfo = userInfoFutureList.get(i).get();
            System.out.println(userInfo);
        }
        mainThreadDo();
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(Thread.currentThread() + "\t" + "业务处理完毕");
    }


    public static void mainThreadDo() {
        System.out.println(Thread.currentThread() + "\t" + "主线程开始执行别的逻辑");
        sleep();
        System.out.println(Thread.currentThread() + "\t" + "主线程结束执行别的逻辑");
    }

    /**
     * 查询数据库并返回所有用户ID列表
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
