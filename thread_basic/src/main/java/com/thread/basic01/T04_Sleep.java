package com.thread.basic01;

/**
 * sleep 方法会让线程让出CPU
 * 睡眠期间，线程可以被中断，如果被中断，会抛出InterruptedException
 */
public class T04_Sleep {
    public static class HelloThread implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 20; i++) {
                System.out.println("thread name: "+Thread.currentThread().getName());
                System.out.println("----------------------------------------------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
