package com.xuelianyong.timewheel.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * @program: java-study
 * @description: 时间槽
 * @author: junpeng.li
 * @create: 2022-04-14 20:24
 **/
public class TimerTaskSlot implements Delayed {

    /**
     * 过期时间
     */
    private AtomicLong expiration = new AtomicLong(-1L);

    /**
     * 根节点
     */
    private TimerTask root = new TimerTask(-1L, null);

    /**
     * 静态初始化
     */ {
        root.pre = root;
        root.next = root;
    }

    /**
     * 设置过期时间
     *
     * @param expiration
     * @return
     */
    public boolean setExpiration(long expiration) {
        return this.expiration.getAndSet(expiration) != expiration;
    }

    /**
     * 获取过期时间
     *
     * @return
     */
    public long getExpiration() {
        return expiration.get();
    }

    /**
     * 增加任务
     *
     * @param timerTask
     */
    public void addTimerTask(TimerTask timerTask) {
        synchronized (this) {
            if (timerTask.timerTaskSlot == null) {
                timerTask.timerTaskSlot = this;
                TimerTask tail = root.pre;
                timerTask.next = root;
                timerTask.pre = tail;
                tail.next = timerTask;
                root.pre = timerTask;
            }
        }
    }

    /**
     * 移出任务
     *
     * @param timerTask
     */
    public void removeTimerTask(TimerTask timerTask) {
        synchronized (this) {
            if (timerTask.timerTaskSlot.equals(this)) {
                timerTask.next.pre = timerTask.pre;
                timerTask.pre.next = timerTask.next;
                timerTask.timerTaskSlot = null;
                timerTask.next = null;
                timerTask.pre = null;
            }
        }
    }

    /**
     * 重新分配
     *
     * @param flush
     */
    public synchronized void flush(Consumer<TimerTask> flush) {
        TimerTask timerTask = root.next;
        while (!timerTask.equals(root)) {
            this.removeTimerTask(timerTask);
            flush.accept(timerTask);
            timerTask = root.next;
        }
        expiration.set(-1L);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return Math.max(0, unit.convert(expiration.get() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof TimerTaskSlot) {
            return Long.compare(expiration.get(), ((TimerTaskSlot) o).expiration.get());
        }
        return 0;
    }
}
