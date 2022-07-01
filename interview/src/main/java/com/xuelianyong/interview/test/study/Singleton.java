package com.xuelianyong.interview.test.study;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-30 13:57
 **/
public class Singleton {

    private static int x = 0;

    private static int y;

    private static Singleton instance = new Singleton();

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.x);
        System.out.println(Singleton.y);
    }
}
