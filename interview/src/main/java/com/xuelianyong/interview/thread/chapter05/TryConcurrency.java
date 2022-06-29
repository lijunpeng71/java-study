package com.xuelianyong.interview.thread.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-24 13:33
 **/
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(() -> browseNews()).start();
        enjoyMusic();
    }

    /**
     * Listening and enjoy the music
     */
    private static void enjoyMusic() {
        for(;;){
            System.out.println("Un-huh,the nice music");
            sleep(1);
        }
    }

    /**
     * Browse the latest news
     */
    private static void browseNews() {
        for(;;){
            System.out.println("Un-huh,the good news");
            sleep(1);
        }
    }

    /**
     * Simulate the wait and ignore exception
     * @param timeout
     */
    private static void sleep(long timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
