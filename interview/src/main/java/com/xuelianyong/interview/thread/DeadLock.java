package com.xuelianyong.interview.thread;

import static java.lang.Thread.currentThread;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-28 14:02
 **/
public class DeadLock {

    private final Object MUTEX_READ = new Object();

    private final Object MUTEX_WRITE = new Object();

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(currentThread().getName() + " get Read lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(currentThread().getName() + " get Write lock");
            }
            System.out.println(currentThread().getName() + " release Write lock");
        }
        System.out.println(currentThread().getName() + " release Read lock");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(currentThread().getName() + " get Write lock");
            synchronized (MUTEX_READ) {
                System.out.println(currentThread().getName() + " get Read lock");
            }
            System.out.println(currentThread().getName() + " release Read lock");
        }
        System.out.println(currentThread().getName() + " release Write lock");
    }

    public static void main(String[] args) {
        final DeadLock deadLock=new DeadLock();
        new Thread(()->{
            while(true){
                deadLock.read();
            }
        },"READ-THREAD").start();

        new Thread(()->{
            while(true){
                deadLock.write();
            }
        },"WRITE-THREAD").start();
    }
}
