package com.cyinfo.study.interview.volatilestudy.demo01;

import java.util.concurrent.TimeUnit;

/**
 * @author GW00171873
 * 1.验证volatile的可见性
 * 1.1 假如int number=0; number变量之前根本没有添加volatile关键字修饰
 */
public class VolatileTest {
    public static void main(String[] args) {
        seeOkByVolatile();
    }

    public static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                //暂停一会儿线程
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);
        }).start();

        //第二个线程就是我们的main线程
        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}