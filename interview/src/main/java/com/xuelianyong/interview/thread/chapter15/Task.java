package com.xuelianyong.interview.thread.chapter15;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-01 14:15
 **/
@FunctionalInterface
public interface Task<T> {

    /**
     * 任务执行接口，该接口允许有返回值
     *
     * @return
     */
    T call();
}
