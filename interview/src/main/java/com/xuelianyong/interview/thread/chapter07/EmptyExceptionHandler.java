package com.xuelianyong.interview.thread.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-29 13:28
 **/
public class EmptyExceptionHandler {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());
        final Thread thread=new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println(1/0);
        },"Test-Thread");
        thread.start();
    }
}
