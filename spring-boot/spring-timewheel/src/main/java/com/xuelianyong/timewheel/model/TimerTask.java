package com.xuelianyong.timewheel.model;

import java.io.Serializable;

/**
 * @program: java-study
 * @description: 任务
 * @author: junpeng.li
 * @create: 2022-04-14 20:19
 **/
public class TimerTask implements Serializable {

    /**
     * 延迟时间
     */
    private long delayMs;

    /**
     * 任务
     */
    private Runnable task;

    /**
     * 时间槽
     */
    protected TimerTaskSlot timerTaskSlot;

    /**
     * 下一个节点
     */
    protected TimerTask next;

    /**
     * 上一个节点
     */
    protected TimerTask pre;

    /**
     * 描述
     */
    protected String desc;

    public TimerTask(long delayMs, Runnable task) {
        this.delayMs = System.currentTimeMillis() + delayMs;
        this.task = task;
        this.timerTaskSlot = null;
        this.next = null;
        this.pre = null;
    }

    public Runnable getTask() {
        return task;
    }

    public long getDelayMs() {
        return delayMs;
    }

    @Override
    public String toString() {
        return desc;
    }
}
