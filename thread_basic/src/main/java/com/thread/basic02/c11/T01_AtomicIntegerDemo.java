package com.thread.basic02.c11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 16-1 AtomicInteger的应用实例
 */
public class T01_AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger(0);
    static class Visitor extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException{
        int num = 100;
        Thread[]ts = new Thread[num];
        for (int i =0; i< num;i++) {
            ts[i] = new Visitor();
            ts[i].start();
        }

        for (int i =0; i< num;i++) {

            ts[i].join();
        }


        System.out.println(counter.get());
    }
}
