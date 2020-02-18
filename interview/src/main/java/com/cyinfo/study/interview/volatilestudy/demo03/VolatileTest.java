package com.cyinfo.study.interview.volatilestudy.demo03;

/**
 * @author GW00171873
 * <p>
 * 2.验证volatile不保证原子性
 * 2.1原子性值的是什么意思？
 * 不可分割，完整性，也即某个线程正在做某个具体业务时,中间不可以被加塞或者分割。
 * 需要整体完整
 * 要么同时成功,要么同时失败
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i < 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少？
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
    }
}
