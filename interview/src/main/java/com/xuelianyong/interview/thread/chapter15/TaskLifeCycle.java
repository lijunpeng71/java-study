package com.xuelianyong.interview.thread.chapter15;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-01 14:03
 **/
public interface TaskLifeCycle<T> {

    /**
     * 任务启动时会触发onStart方法
     *
     * @param thread
     */
    void onStart(Thread thread);

    /**
     * 任务正在运行时会触发onRunning方法
     *
     * @param thread
     */
    void onRunning(Thread thread);

    /**
     * 任务运行结束时会触发onFinish方法，其中result是任务执行结束后的结果
     *
     * @param thread
     * @param result
     */
    void onFinish(Thread thread, T result);

    /**
     * 任务执行报错时会触发onError方法
     *
     * @param thread
     * @param e
     */
    void onError(Thread thread, Exception e);

    class EmptyLifecycle<T> implements TaskLifeCycle {
        @Override
        public void onStart(Thread thread) {
            System.out.println("onStart");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println("onRunning");
        }

        @Override
        public void onFinish(Thread thread, Object result) {
            System.out.println("onFinish");
        }

        @Override
        public void onError(Thread thread, Exception e) {
            System.out.println("onError");
        }
    }
}
