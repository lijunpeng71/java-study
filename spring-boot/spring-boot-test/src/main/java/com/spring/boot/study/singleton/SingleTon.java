package com.spring.boot.study.singleton;

public class SingleTon {

    private SingleTon() {
    }

    private static class SingleTonHolder {
        private static SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance() {
        return SingleTonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        SingleTon singleTon01 = SingleTon.getInstance();
        SingleTon singleTon02 = SingleTon.getInstance();
        System.out.println(singleTon01 == singleTon02);
    }
}
