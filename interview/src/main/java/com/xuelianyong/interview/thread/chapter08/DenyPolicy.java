package com.xuelianyong.interview.thread.chapter08;

/**
 * @program: java-study
 * @description: 拒绝策略
 * @author: junpeng.li
 * @create: 2022-06-29 14:30
 **/
@FunctionalInterface
public interface DenyPolicy {

    /**
     * 拒绝策略接口
     * @param runnable
     * @param threadPool
     */
    void reject(Runnable runnable, ThreadPool threadPool);

    /**
     * 该拒绝策略会直接讲任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            //do nothing;
        }
    }

    /**
     * 该拒绝策略会向任务提交者抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The runnable "+ runnable+ " will be abort.");
        }
    }

    /**
     * 该拒绝策略会使任务在提交者所在线程中执行任务
     */
    class RunnerDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if(!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }
}
