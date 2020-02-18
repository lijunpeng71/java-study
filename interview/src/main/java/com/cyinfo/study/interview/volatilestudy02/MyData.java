package com.cyinfo.study.interview.volatilestudy02;

class MyData {

    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}
