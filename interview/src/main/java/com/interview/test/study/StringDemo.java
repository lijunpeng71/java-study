package com.interview.test.study;

/**
 * Created on 2021/1/28.
 *
 * @author junpeng li
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "tommy";
        Object o = s;
        sayHello(s);
        sayHello(o);

    }

    public static void sayHello(String to) {
        System.out.println(String.format("Hello,%s", to));
    }

    public static void sayHello(Object to) {
        System.out.println(String.format("Welcome,%s", to));
    }
}
