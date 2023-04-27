package lab.lecture04.B_interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题01
 * 实现一个容器
 */
public class T02_Interview {
    private volatile List lists = Collections.synchronizedList(new LinkedList<>());
    public synchronized void add(Object o){
        lists.add(o);
    }

    public synchronized int size(){
        return lists.size();
    }


    public static void main(String[] args) {
        T02_Interview container = new T02_Interview();
        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock){
                System.out.println("t2 start");
                if(container.size()!=5){
                    try {
                        lock.wait(); //线程阻塞在这里等待---释放锁了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end!");
                lock.notify();

            }
        }).start();




        new Thread(()->{
            System.out.println("t1 start");
            synchronized (lock){
                for (int i = 0; i <10 ; i++) {
                    container.add(new Object());
                    System.out.println("add "+ (i+1));
                    if(container.size() == 5){
                        lock.notify(); //通知t2
                        try {
                            lock.wait(); //释放锁，让t2执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        },"t1").start();



    }

}
