package lab.lecture04.B_interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题01
 * 实现一个容器
 */
public class T01_Interview {
    private volatile List lists = Collections.synchronizedList(new LinkedList<>());
    public synchronized void add(Object o){
        lists.add(o);
    }

    public synchronized int size(){
        return lists.size();
    }


    public static void main(String[] args) {
        T01_Interview container = new T01_Interview();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                container.add(new Object());
                System.out.println("add "+ (i+1));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t1").start();


        new Thread(()->{
            while(true){
                if(container.size()==5){
                    break;
                }
            }
            System.out.println("t2 end");
        }).start();
    }

}
