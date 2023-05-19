package com.thread.basic01.c43;

/**
 * 说明：
 * 线程调用join, wait,sleep方法会进入WAITING或TIMED_WAITING状态
 * 对线程对象调用interrupt会使得该线程抛出InterruptedException
 * 抛出异常后，中断标志位会被清空，而不是设置
 */
public class T01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());  //输出false
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(100);
        t.interrupt();
    }
}
