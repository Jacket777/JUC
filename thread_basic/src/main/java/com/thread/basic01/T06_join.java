package com.thread.basic01;

/**
 * join 方法
 *
 */
public class T06_join {
    public static class HelloThread implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 20; i++) {
                System.out.println("thread name: "+Thread.currentThread().getName());
               // System.out.println("----------------------------------------------");

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1  = new Thread(new HelloThread()," A");


        t1.start();
        t1.join();  //主线程必须等待该线程结束才执行一下条语句，比较不通点


        System.out.println("..main end.." );

    }
}
