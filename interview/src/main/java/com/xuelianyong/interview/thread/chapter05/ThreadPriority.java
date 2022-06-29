package com.xuelianyong.interview.thread.chapter05;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-27 13:13
 **/
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while(true){
                System.out.println("T1");
            }
        });
        t1.setPriority(3);
        Thread t2=new Thread(()->{
            while(true){
                System.out.println("T2");
            }
        });
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
