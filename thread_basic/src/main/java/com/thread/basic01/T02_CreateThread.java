package com.thread.basic01;

/**
 * 2. 创建线程与线程的基本方法
 * setPriority(10)
 * getPriority()
 */
public class T02_CreateThread {
   public static class HelloThread implements Runnable{
        @Override
        public void run(){
            Thread.currentThread().setPriority(10);
            System.out.println("thread name: "+Thread.currentThread().getName()+" thread priority "+Thread.currentThread().getPriority());
            System.out.println("thread name: "+Thread.currentThread().getName()+" thread state "+Thread.currentThread().getState());
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t  = new Thread(new HelloThread()," A");
        t.start();
        System.out.println("thread name: "+Thread.currentThread().getName()+" thread priority "+Thread.currentThread().getPriority());
        Thread.sleep(10000);  //注意加与不加的区别---加了之后等待线程结束获取线程的状态为TERMINATED
        System.out.println("thread name" + t.getName()+" state: "+t.getState());
        System.out.println("thread name" + t.getName()+" isAlive: "+t.isAlive());
    }
}
