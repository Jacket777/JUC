package com.thread.basic01.c43;

/**
 * 说明：
 * 线程waiting状态下处理异常
 */
public class InterruptWaitingDemo extends Thread{
    @Override
    public void run() {
        //case 1 比较好的做法--加判断
        while(!Thread.currentThread().isInterrupted()){
            try {
                //模拟任务代码
                Thread.sleep(2000);
            } catch (InterruptedException e) {
               //清理操作
                //重设中断标志位为true
                Thread.currentThread().interrupt();
            }


        }
        System.out.println(isInterrupted());

    }

    public static void main(String[] args) throws InterruptedException {
        InterruptWaitingDemo t = new InterruptWaitingDemo();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
