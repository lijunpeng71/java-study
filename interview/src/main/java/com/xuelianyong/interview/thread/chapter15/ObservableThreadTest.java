package com.xuelianyong.interview.thread.chapter15;

import java.util.concurrent.TimeUnit;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-01 14:42
 **/
public class ObservableThreadTest {
    public static void main(String[] args) {
        TaskLifeCycle<String> taskLifeCycle = new TaskLifeCycle.EmptyLifecycle<String>() {
            @Override
            public void onFinish(Thread thread, Object result) {
                System.out.println(" The result is " + result);
            }
        };
        Observable observableThread = new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" finished done. ");
            return null;
        });
        observableThread.start();
    }
}
