package lab.lecture03.B_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrantlock 用法 4
 * lock.lockInterruptibly(); 线程可以被打断
 */
public class T02_ReentrantLock04 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t01 = new Thread(()->{
            try{
                lock.lockInterruptibly();
                System.out.println("t01 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t01 end");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        t01.start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t01.interrupt();


    }
}
