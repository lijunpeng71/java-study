package com.xuelianyong.interview.thread.chapter08;

/**
 * @program: java-study
 * @description: 存放提交的Runnable, 是一个BlockedQueue,并且有limit限制
 * @author: junpeng.li
 * @create: 2022-06-29 14:26
 **/
public interface RunnableQueue {

    /**
     * 当有新的任务进来时首先会offer到队列中
     *
     * @param runnable
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方法获取Runnable
     *
     * @return
     */
    Runnable take() throws InterruptedException;

    /**
     * 获取任务队列中任务的数量
     *
     * @return
     */
    int size();
}
