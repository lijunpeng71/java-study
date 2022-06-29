package com.xuelianyong.interview.thread.chapter06;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-06-29 10:43
 **/
public class ThreadGroupCreator {
    public static void main(String[] args) {
        //获取当前线程的group
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        //定义一个新的ThreadGroup
        ThreadGroup group1 = new ThreadGroup("group1");
        //程序输出 true
        System.out.println(group1.getParent() == currentGroup);
        //定义group2,并指定group1为其父group
        ThreadGroup group2 = new ThreadGroup(group1, "group2");
        //程序输出true
        System.out.println(group2.getParent() == group1);
    }
}
