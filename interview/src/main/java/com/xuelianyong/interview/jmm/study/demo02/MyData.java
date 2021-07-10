package com.xuelianyong.interview.jmm.study.demo02;

/**
 * @author GW00171873
 */
public class MyData {

    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}
