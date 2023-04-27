package lab.lecture03.F_ReadWriteLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用普通互斥锁
 */
public class T01_Lock {
    private static Lock lock = new ReentrantLock();
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
            new Thread(()->read(lock)).start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->write(lock,new Random().nextInt())).start();
        }
    }

}
