package com.cyinfo.study.interview.volatilestudy.demo03;

/**
 * @author GW00171873
 */
public class MyData {

    volatile int number = 0;

    public void addPlusPlus() {
        this.number++;
    }
}
