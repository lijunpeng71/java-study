package com.xuelianyong.interview.lock.study;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2021/1/24.
 *
 * @author junpeng li
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();


        reentrantLock.unlock();
    }
}
