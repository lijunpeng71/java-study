package com.xuelianyong.interview.thread.chapter08;

/**
 * @program: java-study
 * @description: 创建线程的工厂
 * @author: junpeng.li
 * @create: 2022-06-29 14:29
 **/
@FunctionalInterface
public interface ThreadFactory {
    /**
     * 创建线程
     *
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);
}
