package com.xuelianyong.interview.thread.chapter15;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-01 13:59
 **/
public interface Observable {
    /**
     * 任务生命周期的枚举类型
     */
    enum Cycle {
        STARTED, RUNNING, DONE, ERROR
    }

    /**
     * 获取当前任务的生命周期状态
     * @return
     */
    Cycle getCycle();

    /**
     * 定义启动线程的方法，主要左右是为了屏蔽Thread的其他方法
     */
    void start();

    /**
     * 定义线程打断方法，作用与start方法一样，也是为了屏蔽Thread的其他方法
     */
    void interrupt();
}
