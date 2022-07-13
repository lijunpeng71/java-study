package com.xuelianyong.interview.thread.chapter15;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2022-07-01 14:17
 **/
public class ObservableThread<T> extends Thread implements Observable {

    private final TaskLifeCycle<T> taskLifeCycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(Task<T> task) {
        this(new TaskLifeCycle.EmptyLifecycle<T>(), task);
    }

    public ObservableThread(TaskLifeCycle<T> taskLifeCycle, Task<T> task) {
        super();
        if (task == null) {
            throw new IllegalArgumentException("The task is required.");
        }
        this.taskLifeCycle = taskLifeCycle;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            this.update(Cycle.STARTED,null,null);
            this.update(Cycle.RUNNING,null,null);
            T result=this.task.call();
            this.update(Cycle.DONE,result,null);
        } catch (Exception e) {
            this.update(Cycle.ERROR,null,e);
        }
    }

    private void update(Cycle cycle, T result, Exception e) {
        this.cycle = cycle;
        if (taskLifeCycle == null) {
            return;
        }
        switch (cycle) {
            case STARTED:
                this.taskLifeCycle.onStart(currentThread());
                break;
            case RUNNING:
                this.taskLifeCycle.onRunning(currentThread());
                break;
            case DONE:
                this.taskLifeCycle.onFinish(currentThread(), result);
                break;
            case ERROR:
                this.taskLifeCycle.onError(currentThread(), e);
                break;
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
