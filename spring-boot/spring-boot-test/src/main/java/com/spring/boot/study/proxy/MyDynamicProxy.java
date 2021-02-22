package com.spring.boot.study.proxy;

public class MyDynamicProxy {

    public void test1() {
        Integer integer = 1;
        int unboxing = integer++;
    }

    public static void main(String[] args) {
        Integer intValue = Integer.valueOf(1);
    }
}
