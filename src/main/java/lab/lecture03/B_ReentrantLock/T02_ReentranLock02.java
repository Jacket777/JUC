package lab.lecture03.B_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的使用
 */
public class T02_ReentranLock02 {
    public Lock lock = new ReentrantLock();

    public void m01(){
        try {
            lock.lock(); //相当于synchronized this
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();//必须手动释放锁
        }
    }


    public void m02(){
        try{
            lock.lock();
            System.out.println("m2.........");
        }finally{
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        T02_ReentranLock02 t = new T02_ReentranLock02();
        new Thread(t::m01,"thread01").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        new Thread(t::m02,"thread02").start();

    }



}
