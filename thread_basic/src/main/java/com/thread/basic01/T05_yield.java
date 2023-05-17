package com.thread.basic01;

/**
 * yield 方法
 * 只是告诉操作系统的调度器，只是建议，可以先让其他线程运行
 */
public class T05_yield {
    public static class HelloThread implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 20; i++) {
                System.out.println("thread name: "+Thread.currentThread().getName());
               // System.out.println("----------------------------------------------");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(new HelloThread()," A");
        Thread t2  = new Thread(new HelloThread()," B");

        t1.start();
        t2.start();

        System.out.println("..main end.." );

    }
}
