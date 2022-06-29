package com.xuelianyong.interview.thread.chapter08;

/**
 * @program: java-study
 * @description: 线程池具备的基本操作和方法
 * @author: junpeng.li
 * @create: 2022-06-29 14:13
 **/
public interface ThreadPool {

    /**
     * 提交任务到线程池
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池的初始化大小
     * @return
     */
    int getInitSize();

    /**
     * 获取线程最大的线程数
     * @return
     */
    int getMaxSize();

    /**
     * 获取线程池的核心线程数量
     * @return
     */
    int getCoreSize();

    /**
     * 获取线程中用于缓存然乌队列的大小
     * @return
     */
    int getQueueSize();

    /**
     * 获取线程池中活跃的线程数量
     * @return
     */
    int getActiveCount();

    /**
     * 查看线程池是否已经被关闭
     * @return
     */
    boolean isShutdown();
}
