package com.xuelianyong.interview.thread.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-27 13:19
 **/
public class ThreadInterrupt {
    public static void main(String[] args) {
        //1、判断当前线程是否被中断
        System.out.println("Main Thread is interrupted ? " + Thread.interrupted());
        //2、中断当前线程
        Thread.currentThread().interrupt();
        //3、判断当前线程是否已经被中断
        System.out.println("Main Thread is interrupted ? " + Thread.currentThread().isInterrupted());

        try {
            //4、当前线程执行可中断方法
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            //5、捕获中断信号
            System.out.println("I will be interrupted still.");
        }
    }
}
