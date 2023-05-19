package com.thread.basic01.c43;

/**
 * 设置线程中断标志位
 * 线程如果处于BLOCKED状态，则调用interrupt方法并不能让一个等待锁的线程真正中断
 */
public class InterruptSynchronizedDemo {
    private static Object lock = new Object();
    private static class A extends Thread{
        @Override
        public void run() {
            System.out.println("======A start=======");
            synchronized (lock){
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("running");
                }
            }
            System.out.println("exit");
        }
    }

    public static void test()throws InterruptedException{
        synchronized (lock){
            System.out.println("---------");
            A a = new A();
            a.start();
            Thread.sleep(1000);
            a.interrupt();
            a.join();
            System.out.println("-----end----");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
