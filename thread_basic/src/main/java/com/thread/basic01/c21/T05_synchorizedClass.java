package com.thread.basic01.c21;

/**
 * 15-8 多线程访问synchornized修饰静态方法
 */
public class T05_synchorizedClass {
    private static class Counter {
        private static int count;

        public static void incr() {
            synchronized (Counter.class) {
                count++;
            }
        }

        public static int getCount() {
            synchronized (Counter.class) {
                return count;
            }
        }
    }


    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Counter.incr();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread();
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }

        System.out.println(Counter.getCount());

    }
}
