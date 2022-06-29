package com.xuelianyong.interview.thread.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-29 13:13
 **/
public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {
        //创建一个ThreadGroup
        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(myGroup, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        Thread[] threadList = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(threadList);
        System.out.println(recurseSize);
        recurseSize = mainGroup.enumerate(threadList, false);
        System.out.println(recurseSize);
    }
}
