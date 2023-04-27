package lab.lecture03.B_ReentrantLock;


import java.util.concurrent.TimeUnit;

/**
 * reentrantlock用于替代synchronized
 * synchronize 锁可重入
 */
public class T01_ReentrantLock01B {
    public synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            //锁重入
            if(i==2){
                m2();
            }
        }
    }



    public synchronized void m2(){
        System.out.println("m2...........");
    }


    public static void main(String[] args) {
        T01_ReentrantLock01B t = new T01_ReentrantLock01B();
        new Thread(t::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
