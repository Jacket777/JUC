package lab.lecture03.A_Atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 比较三类
 * Sync
 * Atomic
 * LongAddr
 */

public class T02_AtomicCompare {
    public static long count01 = 0L;
    public static AtomicLong count02 = new AtomicLong(0L);
    public static LongAdder count03 = new LongAdder();


    public static void main(String[] args) {
        Thread[] threads = new Thread[1000];
        //1.sync
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            for (int j = 0; j < 1000000; j++) {
                                synchronized (lock) {
                                    count01++;
                                }
                            }
                        }
                    }
            );
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Sync: " + count01 + " time " + (end - start));

        //2.Atomic
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count02.incrementAndGet();
                }
            });
        }


        start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Atomic: " + count02.get() + " time " + (end - start));


        //3.LongAddr
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                count03.increment();
            });
        }


        start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("LongAddr: " + count03 + " time " + (end - start));


    }
}
