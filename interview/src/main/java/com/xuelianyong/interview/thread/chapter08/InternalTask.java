package com.xuelianyong.interview.thread.chapter08;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-29 14:50
 **/
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前任务未running并且没有被中断，则其将不断地从queue中获取runnable,然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    /**
     *
     */
    public void stop() {
        this.running = false;
    }
}
