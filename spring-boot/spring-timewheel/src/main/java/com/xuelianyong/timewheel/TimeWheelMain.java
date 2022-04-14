package com.xuelianyong.timewheel;

import com.xuelianyong.timewheel.model.Timer;
import com.xuelianyong.timewheel.model.TimerTask;

import java.util.concurrent.CountDownLatch;

/**
 * @program: java-study
 * @description: 时间轮
 * @author: junpeng.li
 * @create: 2022-04-14 20:11
 **/
public class TimeWheelMain {

    private static int intCount = 0;

    private static int runCount = 0;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        Timer timer = new Timer();
        for (int i = 1; i <= 1000; i++) {
            TimerTask timerTask = new TimerTask(i, () -> {
                countDownLatch.countDown();
                int index = addRun();
                System.out.println(index + "----------执行");
            });
            timer.addTimerTask(timerTask);
            System.out.println(i + "+++++++++++++加入");
            intCount++;
        }
        TimerTask timerTask = new TimerTask(5000, () -> {
            countDownLatch.countDown();
            int index = addRun();
            System.out.println(index + "----------执行");
        });
        timer.addTimerTask(timerTask);
        try {
            countDownLatch.await();
            System.out.println("intCount:" + intCount);
            System.out.println("runCount:" + runCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static int addRun() {
        runCount++;
        return runCount;
    }
}
