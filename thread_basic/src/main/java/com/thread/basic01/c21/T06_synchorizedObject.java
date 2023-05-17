package com.thread.basic01.c21;

/**
 * 15-9 使用单独对象作为锁的Counter对象
 */
public class T06_synchorizedObject {
    private static class Counter{
        private int count;
        private Object lock = new Object();
        public  void incr() {
            synchronized (lock){
                count++;
            }
        }

        public  int getCount(){
            synchronized (lock){
                return count;
            }
        }
    }


    static class CounterThread extends Thread{
        Counter counter;
        public CounterThread(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incr();
            }
           // System.out.println("thread name: "+Thread.currentThread().getName()+ " state: "+Thread.currentThread().getState());
        }
    }


    public static void main(String[] args) throws InterruptedException{
        int num = 1000;
        Counter counter = new Counter();
        Thread[]threads = new Thread[num];
        for (int i = 0; i < num ; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }

        for (int i = 0; i < num ; i++) {
            threads[i].join();
        }

        System.out.println(counter.getCount());

    }
}
