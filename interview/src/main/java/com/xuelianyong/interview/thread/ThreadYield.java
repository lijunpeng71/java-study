package com.xuelianyong.interview.thread;

import java.util.stream.IntStream;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-27 13:08
 **/
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            if (index == 0) {
                Thread.yield();
            }
            System.out.println("index=" + index);
        });
    }
}
