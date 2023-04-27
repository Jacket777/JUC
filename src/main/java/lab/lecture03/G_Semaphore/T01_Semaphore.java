package lab.lecture03.G_Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 信号灯
 * 限流
 * 知识点扩充
 */
public class T01_Semaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);//只允许1个线程执行
        Semaphore s1 = new Semaphore(2,true);//公平

        new Thread(()->{
            try{
                s.acquire();//如果得到就执行，得不到就阻塞
                System.out.println("T1 running");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T1 running");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                s.release();
            }

        }).start();

        new Thread(()->{
            try{
                s.acquire();//如果得到就执行，得不到就阻塞
                System.out.println("T2 running");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T2 running");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                s.release();
            }

        }).start();

    }
}
