package com.xuelianyong.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-27 19:59
 **/
public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
                while (!isInterrupted()) {
                    //working
                }
                System.out.println("I will be exiting");
            }
        };
        thread.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown.");
        thread.interrupt();
    }
}
