package com.thread.basic01;

/**
 * 1. 创建线程与线程的基本方法
 * run
 * getId
 * getName
 */
public class T01_CreateThread {
   public static class HelloThread extends Thread{
        @Override
        public void run(){
            System.out.println("thread name: "+Thread.currentThread().getName()+" thread: Id"+Thread.currentThread().getId());
            System.out.println("Hello");

        }
    }

    public static void main(String[] args) {
        Thread t  = new HelloThread();
        t.start();
        System.out.println("thread name: "+Thread.currentThread().getName()+" thread: Id"+Thread.currentThread().getId());
    }
}
