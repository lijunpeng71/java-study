package com.xuelianyong.timewheel.model;

import java.io.Serializable;
import java.util.concurrent.DelayQueue;

/**
 * @program: java-study
 * @description: 时间轮
 * @author: junpeng.li
 * @create: 2022-04-14 20:20
 **/
public class TimeWheel implements Serializable {

    /**
     * 一个时间槽的范围
     */
    private long tickMs;

    /**
     * 时间轮大小
     */
    private int wheelSize;

    /**
     * 时间跨度
     */
    private long interval;

    /**
     * 时间槽
     */
    private TimerTaskSlot[] timerTaskSlots;

    /**
     * 当前时间
     */
    private long currentTime;

    /**
     * 上层时间轮
     */
    private volatile TimeWheel overflowWheel;

    /**
     * 一个Timer只有一个delayQueue
     */
    private DelayQueue<TimerTaskSlot> delayQueue;

    public TimeWheel(long tickMs, int wheelSize, long currentTime, DelayQueue<TimerTaskSlot> delayQueue) {
        this.currentTime = currentTime;
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        this.interval = tickMs * wheelSize;
        this.timerTaskSlots = new TimerTaskSlot[wheelSize];
        //currentTime为tickMs的整数倍 这里做取整操作
        this.currentTime = currentTime - (currentTime % tickMs);
        this.delayQueue = delayQueue;
        for (int i = 0; i < wheelSize; i++) {
            timerTaskSlots[i] = new TimerTaskSlot();
        }
    }

    /**
     * 创建或者获取商城时间轮
     *
     * @return
     */
    private TimeWheel getOverflowWheel() {
        if (overflowWheel == null) {
            synchronized (this) {
                if (overflowWheel == null) {
                    overflowWheel = new TimeWheel(interval, wheelSize, currentTime, delayQueue);
                }
            }
        }
        return overflowWheel;
    }

    /**
     * 添加任务到时间轮
     *
     * @param timerTask
     * @return
     */
    public boolean addTimerTask(TimerTask timerTask) {
        long expiration = timerTask.getDelayMs();
        //过去任务直接执行
        if (expiration < currentTime + tickMs) {
            return false;
        } else if (expiration < currentTime + tickMs) {
            //当前时间轮可以容纳该任务 加入时间槽
            long virtualId = expiration / tickMs;
            int index = (int) (virtualId / wheelSize);
            System.out.println("tickMs:" + tickMs + "------- index:" + index + "------expiration:" + expiration);
            TimerTaskSlot timerTaskSlot = timerTaskSlots[index];
            timerTaskSlot.addTimerTask(timerTask);
            if (timerTaskSlot.setExpiration(virtualId * tickMs)) {
                //添加到delayQueue中
                delayQueue.offer(timerTaskSlot);
            }
        } else {
            //放到上一层的时间轮
            TimeWheel timeWheel = getOverflowWheel();
            timeWheel.addTimerTask(timerTask);
        }
        return true;
    }

    /**
     * 推进时间
     *
     * @param timestamp
     */
    public void advanceClock(long timestamp) {
        if (timestamp >= currentTime + tickMs) {
            currentTime = timestamp - (timestamp % tickMs);
            if (overflowWheel != null) {
                this.getOverflowWheel().advanceClock(timestamp);
            }
        }
    }
}
