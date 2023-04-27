package lab.lecture03.B_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的try lock使用
 */
public class T02_ReentranLock03 {
    public Lock lock = new ReentrantLock();

    public void m01(){
        try {
            lock.lock(); //相当于synchronized this
            for (int i = 0; i < 3; i++) {
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
        boolean locked = false;
        try{
           locked= lock.tryLock(5,TimeUnit.SECONDS);//在5秒钟之内尝试拿到锁，如果拿到
            System.out.println("m2........."+locked);
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            if(locked){
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) {
        T02_ReentranLock03 t = new T02_ReentranLock03();
        new Thread(t::m01,"thread01").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        new Thread(t::m02,"thread02").start();

    }



}
