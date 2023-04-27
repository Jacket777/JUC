package lab.lecture03.B_ReentrantLock;


import java.util.concurrent.TimeUnit;

/**
 * reentrantlock用于替代synchronized
 */
public class T01_ReentrantLock01A {
    public synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }



    public synchronized void m2(){
        System.out.println("m2...........");
    }


    public static void main(String[] args) {
        T01_ReentrantLock01A t = new T01_ReentrantLock01A();
        new Thread(t::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m2,"t2").start();
    }


}
