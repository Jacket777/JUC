package com.msb.lab01;


/**
 * 线程池顶级接口，定义一个执行无返回值任务的方法
 */
public interface Executor2 {

    /**
     * 执行无返回值任务
     * 根据Executor的实现判断，可能在新线程，线程池，线程调用中执行
     * @param command
     */
    void execute(Runnable command);
}
