package com.xuelianyong.interview.thread.chapter08;

/**
 * @program: java-study
 * @description: 拒绝策略异常
 * @author: junpeng.li
 * @create: 2022-06-29 14:46
 **/
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
