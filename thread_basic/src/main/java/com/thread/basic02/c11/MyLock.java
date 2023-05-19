package com.thread.basic02.c11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 16-2 使用AtomicInteger实现Lock
 */
public class MyLock {
    private AtomicInteger status = new AtomicInteger(0);
    public void lock(){
        while(!status.compareAndSet(0,1)){
            Thread.yield();
        }
    }

    public void unlock(){
        status.compareAndSet(1,0);
    }
}
