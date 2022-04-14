package com.xuelianyong.timewheel.model;

import java.io.Serializable;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description: 定时器
 * @author: junpeng.li
 * @create: 2022-04-14 20:18
 **/
public class Timer implements Serializable {

    /**
     * 底层时间轮
     */
    private TimeWheel timeWheel;

    /**
     * 一个Timer只有一个delayQueue
     */
    private DelayQueue<TimerTaskSlot> delayQueue = new DelayQueue<>();

    /**
     * 过期任务执行线程
     */
    private ExecutorService workerThreadPool;

    /**
     * 轮询delayQueue获取过期任务线程
     */
    private ExecutorService bossThreadPool;

    public Timer() {
        timeWheel = new TimeWheel(1, 20, System.currentTimeMillis(), delayQueue);
        workerThreadPool = Executors.newFixedThreadPool(100);
        bossThreadPool = Executors.newFixedThreadPool(1);
        bossThreadPool.submit(() -> {
            while (true) {
                this.advanceClock(20);
            }
        });
    }

    /**
     * 添加任务
     *
     * @param timerTask
     */
    public void addTimerTask(TimerTask timerTask) {
        if (!timeWheel.addTimerTask(timerTask)) {
            workerThreadPool.submit(timerTask.getTask());
        }
    }

    /**
     * 获取过期任务
     *
     * @param timeout
     */
    private void advanceClock(long timeout) {
        try {
            TimerTaskSlot timerTaskSlot = delayQueue.poll(timeout, TimeUnit.MILLISECONDS);
            if (timerTaskSlot != null) {
                //推进时间
                timeWheel.advanceClock(timerTaskSlot.getExpiration());
                //执行过期任务
                timerTaskSlot.flush(this::addTimerTask);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
