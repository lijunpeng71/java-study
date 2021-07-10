package com.xuelianyong.interview.lock.study;

/**
 * Created on 2021/1/24.
 *
 * @author junpeng li
 */
public class ReEnterLockDemo {

    private static Object objectLockA = new Object();

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------------外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "------------中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "\t" + "------------内层调用");
                    }
                }
            }
        }, "t1").start();
    }


    public synchronized void m2() {
        System.out.println("============外");
    }

    public synchronized void m3() {
        System.out.println("============中");
    }

    public synchronized void m4() {
        System.out.println("============内");
    }

    public static void main(String[] args) {
        ReEnterLockDemo reEnterLockDemo = new ReEnterLockDemo();
        new Thread(() -> {
            reEnterLockDemo.m2();
        }
        ).start();
        new Thread(() -> {
            reEnterLockDemo.m3();
        }
        ).start();
    }
}
