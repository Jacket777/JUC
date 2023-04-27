package lab.lecture03.B_ReentrantLock;

import com.msb.juc.c010.T;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 公平锁
 */
public class T02_ReentrantLock05 extends Thread{
    private Lock lock = new ReentrantLock(true); //true为公平，

    public void run(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+" 获得锁");
            }finally {
                lock.unlock();
            }
        }

    }


    public static void main(String[] args) {
        T02_ReentrantLock05 t = new T02_ReentrantLock05();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }
}
