package lab.lecture03.F_ReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁
 */
public class T02_ReadWriteLock {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private static int value;

    public static void read(Lock lock){
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void write(Lock lock, int v){
        try{
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            new Thread(()->read(readLock)).start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->write(writeLock,new Random().nextInt())).start();
        }
    }

}