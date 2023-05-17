package com.thread.basic01.c13;

/**
 * 15-3
 * 多线程第2个问题--内存可见性
 * 多个线程可以共享访问和操作相同的变量，但一个线程对一个变量的修改，另一个线程不一定马上能看到，甚至永远看不到
 * 解决方法：
 * 1.使用volatile 关键字
 * 2.使用synchronized关键字
 * 3.显示锁同步
 */
public class T03_Visibility {
    private static boolean shutdown = false;

    static class HelloThread extends Thread{
        @Override
        public void run() {
           while (!shutdown){
               //do nothing
               System.out.println("do nothing");
           }
            System.out.println("exit hello");
        }
    }


    public static void main(String[] args) throws InterruptedException{
        new HelloThread().start();
        Thread.sleep(3000);
        shutdown = true;
        System.out.println("exit main");
    }
}
