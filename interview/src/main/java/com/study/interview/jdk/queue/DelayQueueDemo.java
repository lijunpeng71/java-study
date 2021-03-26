package com.study.interview.jdk.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue=new DelayQueue();
        delayQueue.add(new MyDelayed());
        Delayed myDelayed=null;
        while(myDelayed==null){
            myDelayed= delayQueue.poll();
        }
    }
}

class MyDelayed implements Delayed{

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
