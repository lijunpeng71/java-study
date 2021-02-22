package com.interview.lock.study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2021/1/24.
 *
 * @author junpeng li
 */
public class LockSupportDemo {

    static Object objectLock = new Object();

    public static void lockWaitNotify() {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "--------进入");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "--------被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "--------进入");
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "--------通知");
            }
        }, "B").start();
    }


    public static Lock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();


    public static void lockAwaitSignal() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "--------进入");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "--------被唤醒");
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "--------进入");
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "\t" + "--------通知");
            lock.unlock();
        }, "B").start();

    }


    public static void lockParkUnPark() {
        Thread a = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "--------进入");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "--------被唤醒");
        }, "A");
        a.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "--------进入");
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "--------通知");
        }, "B").start();
    }

    public static void main(String[] args) {
        lockParkUnPark();
    }
}
