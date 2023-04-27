package lab.lecture03.C_CountDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch的使用
 */
public class TestCountDownLatch {
    public static void useCountDownLatch(){
        Thread[]threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j <100 ; j++) {
                    result += j;
                }
                System.out.println(Thread.currentThread().getName()+" end");
                latch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        //等待执行完毕
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");

    }


    /**
     * 使用线程的join方法保证等待每个线程都执行结束
     */
    public static void useJoin(){
        Thread[]threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j <100 ; j++) {
                    result += j;
                }

                System.out.println(Thread.currentThread().getName()+" end");
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("join end");

    }



    public static void main(String[] args) {
       // useCountDownLatch();
        useJoin();
    }
}
