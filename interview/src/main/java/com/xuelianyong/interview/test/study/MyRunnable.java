package com.xuelianyong.interview.test.study;

/**
 * Created on 2021/1/28.
 *
 * @author junpeng li
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}
